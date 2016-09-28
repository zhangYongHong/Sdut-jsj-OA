package cn.opencil.oa.core.web.activiti;

import cn.opencil.oa.core.web.activiti.service.TasksService;
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
    @Test
    public void historyList() {
        tasksService.historyList();
        Assert.assertNotNull(tasksService.historyList());
    }
}
