package cn.opencil.oa.core.web.awards.action;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.ContantKey;
import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.Awards;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.query.AwardsQuery;
import cn.opencil.oa.core.web.awards.service.AwardsService;
import cn.opencil.oa.core.web.basedata.service.SystemDDLService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

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
    @Autowired
    private SystemDDLService systemDDLService;

    private Logger log = Logger.getLogger(AwardsAction.class);
    private Long aid;
    private AwardsQuery awardsQuery;

    @RequiresPermissions("awards:view")
    public String list() {
        awardsQuery = new AwardsQuery();
        awardsQuery.setState(2);
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
        awardsQuery.setState(this.getModel().getState());

        try {
            PageResult<Awards> awardsPageResult = awardsService.getAwardsPageResult(awardsQuery);
            ActionContext.getContext().put("awardsPapers", awardsPageResult);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "notCheck";
    }

    @RequiresPermissions("awards:add")
    public String addUI() {
        return addUI;
    }

    @RequiresPermissions("awards:add")
    public String add() {
        Awards awards = this.getModel();
        awardsService.addAwards(awards);
        startProcess(awards.getAid());
        return "redirectToCheck";
    }

    @RequiresPermissions("awards:update")
    public String update() {
        Awards awards = this.awardsService.getEntryById(this.getModel().getAid());
        BeanUtils.copyProperties(this.getModel(), awards);
        this.awardsService.updateEntry(awards);
        return "redirect";
    }

    @RequiresPermissions("awards:delete")
    public String delete() {
        Long aid = this.getModel().getAid();
        this.awardsService.deleteAwards(aid);
        return "redirect";
    }

    /**
     * 提交获奖管理信息
     *
     * @param id
     * @return
     */
    @RequiresPermissions("awards:startProcess")
    private void startProcess(Long id) {
        awardsService.startProcess(id);
    }

    /**
     * 办理
     */
    @RequiresPermissions("awards:audit")
    public String audit() {
        aid = this.getModel().getAid();
        Awards awards = awardsService.getEntryById(aid);
        HttpSession session = PageUtil.getHttpSession();
        session.setAttribute("aid", aid);
        ActionContext.getContext().put("awards", awards);
        return "audit";
    }

    @RequiresPermissions("awards:audit")
    public String auditDo() {
        Awards awards = this.getModel();
        awardsService.updateAwards(awards);
        HttpSession session = PageUtil.getHttpSession();
        session.setAttribute("state", this.getModel().getState());
        return "redirectToTask";
    }

    @RequiresPermissions("awards:adjust")
    public String adjustUI() {
        aid = this.getModel().getAid();
        Awards awards = awardsService.getEntryById(aid);
        ActionContext.getContext().put("awards", awards);
        return "adjust";
    }

    public String adjust() {
        this.getModel().setState(1);
        awardsService.updateAwards(this.getModel());
        PageUtil.getHttpSession().setAttribute("state", 1);
        return "redirectToTask";
    }

    public String showAnnex() {
        InputStream annex = awardsService.showAnnex(this.getModel().getAid());
        ActionContext.getContext().put("annex", annex);
        return "showAnnex";
    }

    public String downImage() {
        Awards awards = awardsService.downloadImage(this.getModel().getAid());
        InputStream annex = awards.getInputStream();
        ActionContext.getContext().put("annex", annex);
        String filename = awards.getCompetitionView() + ".jpeg";
        try {
            filename = new String(filename.getBytes("gbk"), "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ActionContext.getContext().put("fileName", filename);
        return "downImage";
    }

    public String downZip() {
        try {
            Awards awards = awardsService.downloadZip(this.getModel().getSchoolYear());
            String fileName = systemDDLService.getSystenDDL("schoolYear", Integer.parseInt(this.getModel().getSchoolYear())).getDdlName();
            fileName = new String(fileName.getBytes("gbk"), "iso-8859-1");
            ActionContext.getContext().put("zip", awards.getInputStream());
            ActionContext.getContext().put("fileName", fileName + ".zip");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "downZip";
    }

    public String exportExcel() {

        return "exportExcel";
    }
    //==================================================================


    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

}
