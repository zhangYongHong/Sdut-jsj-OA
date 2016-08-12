package cn.opencil.oa.core.web.awards.action;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.ContantKey;
import cn.opencil.oa.common.util.DateUtil;
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

/**
 * Project Name:SdutOA
 * File Name:AwardsAction.java
 * Date:2016-4-15下午1:39:44
 * Author : 张树伟
 */
@Controller("awardsAction")
@Scope("prototype")
public class AwardsAction extends BaseAction<Awards> {

    private static final long serialVersionUID = 1L;

    @Autowired
    private AwardsService awardsService;

    private Logger log = Logger.getLogger(AwardsAction.class);
    private AwardsQuery awardsQuery;

    public String list() {
        awardsQuery = new AwardsQuery();
        if (this.getModel().getSchoolYear() == null || this.getModel().getSchoolYear().equals(""))
            awardsQuery.setSchoolYear(DateUtil.groupSchoolYear());
        else
            awardsQuery.setSchoolYear(this.getModel().getSchoolYear());
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
            awardsQuery.setState(0);
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
        Awards awards = this.getModel();
        awardsService.addEntry(awards);
        return SUCCESS;
    }

    public String update() {

        Awards awards = this.awardsService.getEntryById(this.getModel().getAid());
        BeanUtils.copyProperties(this.getModel(), awards);
        this.awardsService.updateEntry(awards);
        return "redirect";
    }

    public String delete() {//管理员才能删除
        this.awardsService.deleteEntry(this.getModel().getAid());
        return "redirect";
    }

    /**
     * 提交获奖管理信息
     * @return
     */
    public String startProcess() {
        Long id = this.getModel().getId();
        awardsService.startProcess(id);
        return null;
    }

}
