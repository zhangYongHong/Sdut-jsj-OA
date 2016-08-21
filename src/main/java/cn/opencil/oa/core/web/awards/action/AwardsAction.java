package cn.opencil.oa.core.web.awards.action;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.ContantKey;
import cn.opencil.oa.common.util.DateUtil;
import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.Awards;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.query.AwardsQuery;
import cn.opencil.oa.core.web.awards.service.AwardsService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * Project Name:SdutOA
 * File Name:AwardsAction.java
 * Date:2016-4-15下午1:39:44
 * Author : 张树伟
 */
@Controller
@Scope("prototype")
public class AwardsAction extends BaseAction<Awards> {

    private static final long serialVersionUID = 1L;

    @Autowired
    private AwardsService awardsService;

    private Logger log = Logger.getLogger(AwardsAction.class);
    private AwardsQuery awardsQuery;
    private Long aid;

    public String list() {
        awardsQuery = new AwardsQuery();
        awardsQuery.setState(2);
        if (this.getModel().getSchoolYear() == null || this.getModel().getSchoolYear().equals(""))
            awardsQuery.setSchoolYear(DateUtil.groupSchoolYear());
        else            awardsQuery.setSchoolYear(this.getModel().getSchoolYear());
        try {
            PageResult<Awards> awardsPageResult = awardsService.getAwardsPageResult(awardsQuery);
            ActionContext.getContext().put("awardsPapers", awardsPageResult);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return listAction;
    }

    public String waitForCheckList() {
        awardsQuery = new AwardsQuery();
        User user = (User) ActionContext.getContext().getSession().get(ContantKey.GLOBLE_USER_INFO);
        //默认显示登陆用户新提交的表单信息
        awardsQuery.setEmployeenum(user.getEmployeenum());
        if (this.getModel().getState() == null) {
            awardsQuery.setState(1);
        } else {
            awardsQuery.setState(this.getModel().getState());
        }

        try {
            PageResult<Awards> awardsPageResult = awardsService.getAwardsPageResult(awardsQuery);
            ActionContext.getContext().put("awardsPapers", awardsPageResult);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "notCheck";
    }

    public String addUI() {
        return addUI;
    }

    public String add() {
        User user = PageUtil.getUser();
        Awards awards = this.getModel();
        awards.setFileNum(PageUtil.getFileNum(awards.getClasses()));
        awards.setSchoolYear(DateUtil.groupSchoolYear());
        awards.setEmployeenum(user.getEmployeenum());
        awardsService.addEntry(awards);
        startProcess(awards.getAid());
        return "redirectToCheck";
    }


    public String update() {
        Awards awards = this.awardsService.getEntryById(this.getModel().getAid());
        BeanUtils.copyProperties(this.getModel(), awards);
        this.awardsService.updateEntry(awards);
        return "redirect";
    }

    public String delete() {//管理员才能删除
        Long aid = this.getModel().getAid();
        this.awardsService.deleteEntry(aid);
        return "redirect";
    }

    /**
     * 提交获奖管理信息
     * @return
     * @param id
     */
    private void startProcess(Long id) {
        awardsService.startProcess(id);
    }

    /**
     * 办理
     */
    public String audit() {
        aid = this.getModel().getAid();
        Awards awards = awardsService.getEntryById(aid);
        HttpSession session = PageUtil.getHttpSession();
        session.setAttribute("aid", aid);
        ActionContext.getContext().put("awards", awards);
        return "audit";
    }

    public String auditDo() {
        Awards awards = this.getModel();
        awardsService.updateEntry(awards);
        HttpSession session = PageUtil.getHttpSession();
        session.setAttribute("state", this.getModel().getState());
        return "redirectToTask";
    }

    public String adjustUI() {
        aid = this.getModel().getAid();
        Awards awards = awardsService.getEntryById(aid);
        ActionContext.getContext().put("awards", awards);
        return "adjust";
    }
    public String adjust() {
        this.getModel().setState(1);
        awardsService.updateEntry(this.getModel());
        PageUtil.getHttpSession().setAttribute("state", 1);
        return "redirectToTask";
    }

    //==================================================================


    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }
}
