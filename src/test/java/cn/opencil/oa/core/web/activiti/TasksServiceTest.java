package cn.opencil.oa.core.web.activiti;

import cn.opencil.oa.core.domain.Paper;
import cn.opencil.oa.core.web.activiti.service.TasksService;
import cn.opencil.oa.core.web.test.service.PaperService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with Sdut-jsj-OA.
 * Package: cn.opencil.oa.core.web.activiti
 * User: 张树伟
 * Date: 16-9-28
 * Time: 下午3:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:/cn/opencil/oa/core/spring/applicationContext-*.xml")
public class TasksServiceTest {
    @Autowired
    TasksService tasksService;
    @Autowired
    PaperService paperService;
    @Test
    public void historyList() {
        tasksService.historyList();
        Assert.assertNotNull(tasksService.historyList());
    }

    @Test
    public void test() {
        Paper paper = new Paper();
        paper.setUuid("1233");
        paper.setAnnex("122");
        paper.setAuthor("eeqw");
        paper.setLevel(1);
        paper.setParticpants("sdasd");
        paper.setPublishedDate(new java.sql.Date(122121221212121l));
        paper.setSchoolYear("0");
        paper.setTitle("sdasdas");
        paper.setType(1);
        paper.setVolumePeriod("asdasd");
        paperService.addEntry(paper);
    }
}
