package cn.opencil.oa.core.web.database.service;

import cn.opencil.oa.core.web.basedata.service.UserService;
import cn.opencil.oa.core.web.resource.server.ResourceServer;
import cn.opencil.oa.core.web.role.dao.UserRoleDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;

/**
 * Created by mnzero on 16-9-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:cn/opencil/oa/core/spring/applicationContext-*.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private ResourceServer resourceServer;
    @Autowired
    private UserRoleDao userRoleDao;

    @Test
    public void getRoleTest() {
        HashSet<String> list = new HashSet<>();
        list = (HashSet<String>) userService.getPermissions("666666");
        for (String str : list) {
            System.out.println(str);
        }
    }
    @Test
    public void Test() {
//        Resource r = resourceServer.getOne((long) 2);
//        r.getParentId();
//        userService.getUserByEmployeenum("666666");
        userRoleDao.getAll();
    }

}
