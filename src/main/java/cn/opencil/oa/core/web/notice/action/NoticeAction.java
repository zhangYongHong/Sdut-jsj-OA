package cn.opencil.oa.core.web.notice.action;

import cn.opencil.oa.core.base.action.BaseAction;
import cn.opencil.oa.core.domain.Notice;
import cn.opencil.oa.core.web.notice.service.NoticeService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Collection;

/**
 * Created with Sdut-jsj-OA.
 * Package: cn.opencil.oa.core.web.notice.action
 * User: 张树伟
 * Date: 16-11-9
 * Time: 下午9:34
 */
@Controller
@Scope("prototype")
public class NoticeAction extends BaseAction<Notice> {

    @Autowired
    NoticeService noticeService;

    public String list() {
        Collection<Notice> noticeList = noticeService.getEntrys();
        ActionContext.getContext().put("notices", noticeList);
        return "listAction";
    }

    public String noticeList() {
        Collection<Notice> noticeList = noticeService.getEntrys();
        ActionContext.getContext().put("notices", noticeList);
        return "noticeList";
    }

    public String content() {
        Notice notice = noticeService.getEntryById(this.getModel().getUuid());
        ActionContext.getContext().put("notice", notice);
        return "content";
    }

    public String addUI() {
        return "addUI";
    }

    public String add() {
        String content = getRequest().getParameter("editorValue");
        Notice notice = this.getModel();
        noticeService.addNotice(notice, content);
        return "redirect";
    }

    public String delete() {
        noticeService.deleteEntry(this.getModel().getUuid());
        return "redirect";
    }

    public String moreNotice() {
        Collection<Notice> noticeList = noticeService.getEntrys();
        ActionContext.getContext().put("notices", noticeList);
        return "moreNotice";
    }
}
