package cn.opencil.oa.core.web.test.action;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.Paper;
import cn.opencil.oa.core.query.PaperQuery;
import cn.opencil.oa.core.web.test.service.PaperService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
//        if (schoolYear != null)
//            paperQuery.setSchoolYear(schoolYear.toString());
//        User user = PageUtil.getUser();
//        // 根据当前用户的用户名与第一作者比对
//        paperQuery.setAuthor(user.getUserName());
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
        this.getModel().setUuid(UUID.randomUUID().toString());
        paperService.addPaper(paper);
        return LISTACTION;
    }

    public String updateUI() {
        Paper paper = paperService.getEntryById(this.getModel().getUuid());
        ActionContext.getContext().put("paper", paper);
        return "updateUI";
    }

    public String update() {
        Paper model = this.getModel();
        paperService.updatePaper(model);
        return LISTACTION;
    }

    public String exportExcel() {
        Integer schoolYear = this.getModel().getSchoolYear();
        if (schoolYear == null)
            schoolYear = 0;
        InputStream inputStream = paperService.exportExcel(schoolYear);
//        if (inputStream != null) {
//            String excelName = paperService.getExcelName(schoolYear);
//            ActionContext.getContext().put("inputStream", inputStream);
//            ActionContext.getContext().put("excelName", excelName);
//        } else {
//            return "listAction";
//        }
//        return "excel";
        return null;
    }
}
