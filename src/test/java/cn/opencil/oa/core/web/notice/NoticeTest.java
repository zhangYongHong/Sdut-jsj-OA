package cn.opencil.oa.core.web.notice;

import cn.opencil.oa.core.domain.Notice;
import cn.opencil.oa.core.web.notice.service.NoticeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;

/**
 * Created with Sdut-jsj-OA.
 * Package: cn.opencil.oa.core.web.notice
 * User: 张树伟
 * Date: 16-11-10
 * Time: 上午10:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:cn/opencil/oa/core/spring/applicationContext-*.xml")
public class NoticeTest {

    @Autowired
    NoticeService noticeService;

    @Test
    public void addTest() {
        Notice notice = new Notice();
        notice.setUuid("sdassss");
        Date date = new Date(1);
        notice.setBeginDate(date);
        notice.setContent("你好世界！");
        notice.setTitle("呵呵呵呵呵！");
        notice.setUser("章撒大厦");
        noticeService.addEntry(notice);
    }
}
