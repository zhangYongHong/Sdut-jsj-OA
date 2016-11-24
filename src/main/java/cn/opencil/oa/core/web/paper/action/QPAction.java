package cn.opencil.oa.core.web.paper.action;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.QuestionPaper;
import cn.opencil.oa.core.query.PaperQuery;
import cn.opencil.oa.core.web.paper.service.QPService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.InputStream;

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
    private File uploadfile;
    private String schoolYear;

    @Autowired
    private QPService qpService;

    public String list() {
        PageResult<QuestionPaper> qustionPapers = null;
        Subject subject = SecurityUtils.getSubject();
        if (this.getModel().getSchoolYear() == null || this.getModel().getSchoolYear().equals(""))
            //默认显示数据字典中设置的一个学年信息
            qpQuery.setSchoolYear("1");
        else
            qpQuery.setSchoolYear(this.getModel().getSchoolYear());
        qpQuery.setTeacher(PageUtil.getUser().getUserName());
        if (subject.isPermitted("questionPaper:*")) {
            qpQuery.setTeacher(null);
        }
        qustionPapers = this.qpService.getPageResultForQP(qpQuery);
        ActionContext.getContext().put("questionPapers", qustionPapers);
        return listAction;
    }

    public String addUI() {
        return addUI;
    }

    public String add() {
        QuestionPaper paper = this.getModel();
        try {
            if (this.checkValue(paper)) {
                return INPUT;
            }
            paper.setFileNum(PageUtil.getFileNum(paper.getClassName()));
            paper.setIsChange("未修改");
            this.qpService.addEntry(paper);
        } catch (Exception e) {
            this.addFieldError("qpAddError", "试卷信息添加失败！");
            return INPUT;
        }
        this.addFieldError("qpError", "添加成功！");
        return "redirect";
    }

    public String updateAdminUI() {
        QuestionPaper questionPaper = qpService.getEntryById(this.getModel().getQid());
        ActionContext.getContext().put("old", questionPaper);
        return "updateAdminUI";
    }

    public String updateAdmin() {
        QuestionPaper questionPaper = this.getModel();
        this.qpService.updateEntry(questionPaper);
        return "redirect";
    }

    public String updateUI() {
        tempId = this.getModel().getQid();
        this.loadingValue();
        return updateUI;
    }

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
            this.addFieldError("qpError", "提交成功！");
            return "redirect";
        } catch (Exception e) {
            e.getStackTrace();
            this.loadingValue();
            this.addFieldError("qpError", "提交失败！");
            return updateUI;
        }
    }

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
        String schoolYear = this.getModel().getSchoolYear();
        if (!StringUtils.isNotEmpty(schoolYear))
            schoolYear = "0";
        InputStream inputStream = qpService.exportExcel(schoolYear);
        if (inputStream != null) {
            String excelName = qpService.getExcelName(schoolYear);
            ActionContext.getContext().put("inputStream", inputStream);
            ActionContext.getContext().put("excelName", excelName);
        } else {
            return "listAction";
        }
        return "excel";
    }

    public String loadingExcelUI() {
        return "loadingExcelUI";
    }

    /**
     * 导入Excel
     *
     * @return String
     */
    public String uploadExcel() {
        schoolYear = this.getModel().getSchoolYear();
        qpService.uploadExcel(uploadfile, schoolYear);
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

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }
}
