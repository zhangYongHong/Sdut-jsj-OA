package cn.opencil.oa.core.web.test.action;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.Paper;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.query.PaperQuery;
import cn.opencil.oa.core.web.test.service.PaperService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Sdut-jsj-OA.
 * Package: cn.opencil.oa.core.web.test.action
 * User: 张树伟
 * Date: 16-11-28
 * Time: 下午5:10
 */
@Controller
@Scope("prototype")
public class PaperAction extends BaseAction<Paper> {
    @Autowired
    private PaperService paperService;

    public String list() {
        PaperQuery paperQuery = new PaperQuery();
        Integer schoolYear = this.getModel().getSchoolYear();
        if (schoolYear != null)
            paperQuery.setSchoolYear(schoolYear.toString());
        User user = PageUtil.getUser();
        // 根据当前用户的用户名与第一作者比对
        paperQuery.setAuthor(user.getUserName());
        PageResult<Paper> pageResult = paperService.getPageResult(paperQuery);
        List<Paper> papers = pageResult.getRows();
        if (papers == null)
            ActionContext.getContext().put("papers", new ArrayList<Paper>());
        ActionContext.getContext().put("papers", papers);
        return LISTACTION;
    }


    public String addUI() {
        return "addUI";
    }

    public String add() {
        Paper paper = this.getModel();

        return LISTACTION;
    }
}
