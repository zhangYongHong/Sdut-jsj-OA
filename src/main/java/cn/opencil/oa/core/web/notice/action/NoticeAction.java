package cn.opencil.oa.core.web.notice.action;

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
public class NoticeAction {

    @Autowired
    NoticeService noticeService;

    public String list() {
        Collection<Notice> noticeList = noticeService.getEntrys();
        ActionContext.getContext().put("notices", noticeList);
        return "listAction";
    }
}
