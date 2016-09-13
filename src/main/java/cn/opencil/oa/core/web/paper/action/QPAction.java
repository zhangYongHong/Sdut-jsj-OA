package cn.opencil.oa.core.web.paper.action;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.DateUtil;
import cn.opencil.oa.common.util.ExcelFileGeneratorUtil;
import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.QuestionPaper;
import cn.opencil.oa.core.query.PaperQuery;
import cn.opencil.oa.core.web.paper.service.QPService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

/**
 * Project Name:SdutOA
 * File Name:QPAction.java
 * Date:2016-5-29下午9:29:19
 * Author : 张树伟
 */

@Controller
@Scope("prototype")
public class QPAction extends BaseAction<QuestionPaper> {

    private static final long serialVersionUID = 1L;
    //如果不加static 值不会产生变化
    private static Long tempId;
    private PaperQuery qpQuery = new PaperQuery();
    @Autowired
    private QPService qpService;

    private File uploadfile;

    @RequiresPermissions("questionPaper:view")
    public String list() {
        PageResult<QuestionPaper> qustionPapers = null;
        try {
            if (this.getModel().getSchoolYear() == null || this.getModel().getSchoolYear().equals(""))
                qpQuery.setSchoolYear(DateUtil.groupSchoolYear());
            else
                qpQuery.setSchoolYear(this.getModel().getSchoolYear());
            qustionPapers = this.qpService.getPageResultForQP(qpQuery);
        } catch (Exception e) {
            this.addFieldError("qpListError", "试卷列表获取失败！");
            return listAction;
        }
        ActionContext.getContext().put("qustionPapers", qustionPapers);
        return listAction;
    }

    @RequiresPermissions("questionPaper:add")
    public String addUI() {
        return addUI;
    }

    @RequiresPermissions("questionPaper:add")
    public String add() {
        QuestionPaper paper = this.getModel();
        try {
            if (this.checkValue(paper)) {
                return INPUT;
            }
            paper.setFileNum(PageUtil.getFileNum(paper.getClassName()));
            paper.setSchoolYear(DateUtil.groupSchoolYear());
            paper.setIsChange("未修改");
            this.qpService.addEntry(paper);
        } catch (Exception e) {
            this.addFieldError("qpAddError", "试卷信息添加失败！");
            return INPUT;
        }
        this.addFieldError("qpError", "添加成功！");
        return "redirect";
    }

    @RequiresPermissions("questionPaper:update")
    public String updateUI() {
        tempId = this.getModel().getQid();
        this.loadingValue();
        return updateUI;
    }

    @RequiresPermissions("questionPaper:update")
    public String update() {
        QuestionPaper questionPaper = this.getModel();
        questionPaper.setQid(tempId);

        if (checkValue(questionPaper)) {
            this.loadingValue();
            return updateUI;
        }

        try {
            questionPaper.setFileNum(PageUtil.getFileNum(questionPaper.getClassName()));
            questionPaper.setIsChange("已修改");
            this.qpService.updateEntry(questionPaper);
            this.loadingValue();
            this.addFieldError("qpError", "更新成功！");
            return updateUI;
        } catch (Exception e) {
            e.getStackTrace();
            this.loadingValue();
            this.addFieldError("qpError", "更新失败！");
            return updateUI;
        }
    }

    @RequiresPermissions("questionPaper:delete")
    public String delete() {
        Long id = null;
        try {
            id = this.getModel().getQid();
            this.qpService.deleteEntry(id);
        } catch (Exception e) {
            this.addFieldError("qpDeleteError", "删除失败！");
        }

        // 跳转到列表页面的字符串
        return "redirect";
    }

    /**
     * 导出excel
     *
     * @return
     */
    public String exportExcel() {
        try {
            qpQuery.setSchoolYear(this.getModel().getSchoolYear());
            ArrayList<String> fieldDataName = this.qpService
                    .getFieldDataNameExcel();
            ArrayList<ArrayList<String>> fieldDatas = this.qpService
                    .getFieldDataExcel(qpQuery);
            if (fieldDatas.size() == 0) {
                this.addFieldError("qpError", "当前学期数据为空不可导出！");
            }
            ExcelFileGeneratorUtil excelFileGenerator = new ExcelFileGeneratorUtil(
                    fieldDataName, fieldDatas);
            excelFileGenerator.setTitle(StringUtils.isNotBlank(
                    qpQuery.getSchoolYear()) ? qpQuery.getSchoolYear() : "" + " 试题归档汇总表");
            String filename = DateUtil.dateToYMD() + ".xls";
            filename = new String(filename.getBytes("gbk"), "iso-8859-1");// 转换文件名编码
            this.getRequest().setAttribute("filename", filename);// 将文件名设置到request中

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            excelFileGenerator.expordExcel(os);// 使用输出流，导出
            byte[] buf = os.toByteArray();
            ByteArrayInputStream in = new ByteArrayInputStream(buf);
            // 将文件放置到输入流InputStream
            this.getModel().setInputStream(in);
        } catch (Exception e) {
            this.addFieldError("qpExportExcelError", "文件导出失败！");
        }
        return "excel";
    }

    @RequiresPermissions("page:upload")
    public String loadingExcelUI() {
        return "loadingExcelUI";
    }

    /**
     * 导入Excel
     *
     * @return String
     */
    @RequiresPermissions("page:upload")
    public String uploadExcel() {
        qpService.uploadExcel(uploadfile);
        return "redirect";
    }

    private void loadingValue() {
        QuestionPaper old = this.qpService.getEntryById(tempId);
        if (null != old) {
            ActionContext.getContext().put("old", old);
        } else {
            this.addFieldError("qpError", "信息获取错误，请重新加载页面！");
        }
    }

    private boolean checkValue(QuestionPaper paper) {
        if (paper.getTeacher() == null || paper.getTeacher().trim().equals("")) {
            this.addFieldError("qpError", "授课教师不能为空！");
            return true;
        }
        if (paper.getTeacher().length() <= 0 || paper.getTeacher().length() >= 7) {
            this.addFieldError("qpError", "授课教师要在0~7位之间！");
            return true;
        }
        if (paper.getCourse() == null || paper.getCourse().trim().equals("")) {
            this.addFieldError("qpError", "课程名称不能为空！");
            return true;
        }
        return false;
    }

    //==============================================================
    public File getUploadfile() {
        return uploadfile;
    }

    public void setUploadfile(File uploadfile) {
        this.uploadfile = uploadfile;
    }

    public PaperQuery getQpQuery() {
        return qpQuery;
    }

    public void setQpQuery(PaperQuery qpQuery) {
        this.qpQuery = qpQuery;
    }

}
