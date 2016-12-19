package cn.opencil.oa.core.web.test.action;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.Topics;
import cn.opencil.oa.core.query.PaperQuery;
import cn.opencil.oa.core.web.test.service.TopicsService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * Created with Sdut-jsj-OA.
 * Package: cn.opencil.oa.core.web.test.action
 * User: 张树伟
 * Date: 16-12-19
 * Time: 下午3:07
 */
@Controller
public class TopicsAction extends BaseAction<Topics> {
    @Autowired
    private TopicsService topicsService;

    public String list() {
        PaperQuery paperQuery = new PaperQuery();
        String schoolYear = this.getModel().getSchoolYear();
        Subject subject = SecurityUtils.getSubject();
        if (schoolYear != null)
            paperQuery.setSchoolYear(schoolYear.toString());

        PageResult<Topics> pageResult = topicsService.getPageResult(paperQuery);
        List<Topics> papers = pageResult.getRows();
        if (papers != null)
            ActionContext.getContext().put("topics", papers);
        return LISTACTION;
    }


    public String addUI() {
        return "addUI";
    }

    public String add() {
        Topics topics = this.getModel();
        this.getModel().setUuid(UUID.randomUUID().toString());
        topicsService.addEntry(topics);
        return LISTACTION;
    }

    public String updateUI() {
        Topics topics = topicsService.getEntryById(this.getModel().getUuid());
        ActionContext.getContext().put("topics", topics);
        return "updateUI";
    }

    public String update() {
        Topics model = this.getModel();
        topicsService.updateEntry(model);
        return LISTACTION;
    }

    public String delete() {
        String uuid = this.getModel().getUuid();
        Topics topics = topicsService.getEntryById(uuid);
        topicsService.deleteEntry(uuid);
        ActionContext.getContext().put("schoolYear", topics.getSchoolYear());
        return "redirect";
    }

    public String exportExcel() {
        String schoolYear = this.getModel().getSchoolYear();
        if (!StringUtils.isNotEmpty(schoolYear))
            schoolYear = "0";
        InputStream inputStream = topicsService.exportExcel(schoolYear);
        if (inputStream != null) {
            String excelName = topicsService.getExcelName(schoolYear);
            ActionContext.getContext().put("inputStream", inputStream);
            ActionContext.getContext().put("excelName", excelName);
        } else {
            return "listAction";
        }
        return "excel";
    }
}
