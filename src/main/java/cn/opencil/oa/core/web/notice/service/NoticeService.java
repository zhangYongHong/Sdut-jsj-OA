package cn.opencil.oa.core.web.notice.service;

import cn.opencil.oa.common.util.DateUtil;
import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.Notice;
import cn.opencil.oa.core.web.notice.dao.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.UUID;

/**
 * Created with Sdut-jsj-OA.
 * Package: cn.opencil.oa.core.web.notice.service
 * User: 张树伟
 * Date: 16-11-9
 * Time: 下午9:40
 */
@Service
public class NoticeService extends BaseServiceImpl<Notice> {
    @Autowired
    NoticeDao noticeDao;
    @Override
    public BaseDao getBaseDao() {
        return noticeDao;
    }

    public void addNotice(Notice notice, String content) {
        notice.setUuid(UUID.randomUUID().toString());
        notice.setUser(PageUtil.getUser().getUserName());
        notice.setContent(content);
        long date = DateUtil.getDate();
        notice.setBeginDate(new Date(date));
        this.addEntry(notice);
    }
}
