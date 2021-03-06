package cn.opencil.oa.core.web.test.action;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.DateUtil;
import cn.opencil.oa.common.util.ExcelFileGeneratorUtil;
import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.TrainingPaper;
import cn.opencil.oa.core.query.PaperQuery;
import cn.opencil.oa.core.web.test.service.TPService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

/**
 * Project Name:SdutOA
 * File Name:TPAction.java
 * Date:2016-4-19下午9:29:27
 * Author : 张树伟
 */
@Controller
@Scope("prototype")
public class TPAction extends BaseAction<TrainingPaper> {

    private static final long serialVersionUID = 1L;

    @Autowired
    private TPService tpService;

    private static Long tempId;
    private PaperQuery tpQuery = new PaperQuery();
    private File uploadfile;
    private String schoolYear;

    public String list() {
        PageResult<TrainingPaper> trainingPapers = null;
        Subject subject = SecurityUtils.getSubject();
        tpQuery.setSchoolYear(this.getModel().getSchoolYear());
        //非管理员只能查看自身的试卷列表
        tpQuery.setTeacher(PageUtil.getUser().getUserName());
        if (subject.isPermitted("trainingPaper:*"))
            tpQuery.setTeacher(null);
        trainingPapers = this.tpService
                .getPageResultForTP(tpQuery);
        ActionContext.getContext().put("trainingPapers", trainingPapers);
        return listAction;
    }

    public String addUI() {
        return addUI;
    }

    public String add() {
        TrainingPaper paper = this.getModel();
        if (checkValue(paper)) {
            return INPUT;
        }
        try {
            paper.setFileNum(PageUtil.getFileNum(paper.getClassName()));
            paper.setIsChange("未修改");
            schoolYear = paper.getSchoolYear();
            this.tpService.addEntry(paper);
            this.addFieldError("tpError", "信息添加成功！");
            return "redirect";
        } catch (DataException e) {
            this.addFieldError("tpError", "信息添加失败！");
            return INPUT;
        }
    }

    public String updateAdminUI() {
        TrainingPaper trainingPaper = tpService.getEntryById(this.getModel().getTid());
        ActionContext.getContext().put("old", trainingPaper);
        return "updateAdminUI";
    }

    public String updateAdmin() {
        TrainingPaper trainingPaper = this.getModel();
        schoolYear = trainingPaper.getSchoolYear();
        this.tpService.updateEntry(trainingPaper);
        return "redirect";
    }

    public String updateUI() {
        tempId = this.getModel().getTid();
        this.loadingValue();
        return updateUI;
    }

    public String update() {
        TrainingPaper trainingPaper = this.getModel();
        if (checkValue(trainingPaper)) {
            this.loadingValue();
            return updateUI;
        }
        try {
            trainingPaper.setFileNum(PageUtil.getFileNum(trainingPaper.getClassName()));
            trainingPaper.setIsChange("已修改");
            schoolYear = trainingPaper.getSchoolYear();
            this.tpService.updateEntry(trainingPaper);
            return "redirect";
        } catch (Exception e) {
            this.loadingValue();
            this.addFieldError("tpError", "更新失败！");
            return updateUI;
        }
    }

    public String delete() {
        Long id = this.getModel().getTid();
        schoolYear = this.getModel().getSchoolYear();
        this.tpService.deleteEntry(id);
        return "redirect";
    }

    /**
     * 导出excel
     *
     * @return
     */
    public String exportExcel() {
        try {
            tpQuery.setSchoolYear(this.getModel().getSchoolYear());
            ArrayList<String> fieldDataName = this.tpService
                    .getFieldDataNameExcel();
            ArrayList<ArrayList<String>> fieldDatas = this.tpService
                    .getFieldDataExcel(tpQuery);
            ExcelFileGeneratorUtil excelFileGenerator = new ExcelFileGeneratorUtil(
                    fieldDataName, fieldDatas);

            excelFileGenerator
                    .setTitle(StringUtils.isNotBlank(
                            tpQuery.getSchoolYear()) ? tpQuery.getSchoolYear() : "" + " 实训试题归档汇总表");

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
            this.addFieldError("tpError", "文件导出失败！");
        }
        return "excel";
    }

    public String loadingExcelUI() {
        return "loadingExcelUI";
    }

    /**
     * 导入Excel
     *
     * @param
     * @return
     */
    public String uploadExcel() {

        tpService.uploadExcel(uploadfile, schoolYear);
        return "redirect";
    }

    private boolean checkValue(TrainingPaper paper) {
        if (paper.getTeacher() == null || paper.getTeacher().trim().equals("")) {
            this.addFieldError("tpError", "姓名不能为空！");
            return true;
        }
        if (paper.getTeacher().length() <= 0 || paper.getTeacher().length() >= 7) {
            this.addFieldError("tpError", "教师姓名要在0~7位之间！");
            return true;
        }
        if (paper.getClassName() == null || paper.getClassName().trim().equals("")) {
            this.addFieldError("tpError", "班级不能为空！");
            return true;
        }
        if (paper.getClassName().length() <= 0 || paper.getClassName().length() >= 15) {
            this.addFieldError("qpError", "班级信息要在0~15位之间！");
            return true;
        }
        if (paper.getCourse() == null || paper.getCourse().trim().equals("")) {
            this.addFieldError("tpError", "课程名称不能为空！");
            return true;
        }
        if (paper.getCourse().length() <= 0 || paper.getCourse().length() >= 15) {
            this.addFieldError("qpError", "课程名称要在0~15位之间！");
            return true;
        }

        return false;
    }

    private void loadingValue() {
        TrainingPaper old = this.tpService.getEntryById(tempId);
        if (null == old) {
            this.addFieldError("tpError", "信息获取错误，请重新加载页面！");
        } else {
            ActionContext.getContext().put("old", old);
        }
    }

    //===========================================================================
    public PaperQuery getTpQuery() {
        return tpQuery;
    }

    public void setTpQuery(PaperQuery tpQuery) {
        this.tpQuery = tpQuery;
    }

    public File getUploadfile() {
        return uploadfile;
    }

    public void setUploadfile(File uploadfile) {
        this.uploadfile = uploadfile;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }
}
