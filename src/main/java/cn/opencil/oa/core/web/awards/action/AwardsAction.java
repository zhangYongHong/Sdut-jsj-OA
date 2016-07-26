package cn.opencil.oa.core.web.awards.action;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.Awards;
import cn.opencil.oa.core.query.AwardsQuery;
import cn.opencil.oa.core.web.awards.service.AwardsService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Project Name:SdutOA
 * File Name:AwardsAction.java
 * Date:2016-4-15下午1:39:44
 * Author : 王基伟
 */
@Controller("awardsAction")
@Scope("prototype")
public class AwardsAction extends BaseAction<Awards> {

    private static final long serialVersionUID = 1L;

    @Autowired
    private AwardsService awardsService;

    private AwardsQuery awardsQuery = new AwardsQuery();

    private Log4JLogger log;

    public AwardsQuery getAwardsQuery() {
        return awardsQuery;
    }

    public void setAwardsQuery(AwardsQuery awardsQuery) {
        this.awardsQuery = awardsQuery;
    }

    public String list() {
        try {
            PageResult<Awards> awardsPageResult = awardsService.getAwaPageResult(awardsQuery);
            ActionContext.getContext().put("awardsPapers", awardsPageResult);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return listAction;
    }

    public String addUI() {
        return addUI;
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


}
