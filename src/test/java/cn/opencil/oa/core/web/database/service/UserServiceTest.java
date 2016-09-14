package cn.opencil.oa.core.web.database.service;

import cn.opencil.oa.core.web.basedata.dao.UserDao;
import cn.opencil.oa.core.web.basedata.service.UserService;
import cn.opencil.oa.core.web.resource.server.ResourceServer;
import cn.opencil.oa.core.web.role.dao.RoleDao;
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
    private RoleDao userRoleDao;
    @Autowired
    private UserDao userDao;

    @Test
    public void getRoleTest() {
        HashSet<String> list = new HashSet<>();
        list = (HashSet<String>) userService.getPermissions("1111112");
        for (String str : list) {
            System.out.println(str);
        }
    }
    @Test
    public void Test() {
//        Resource r = resourceServer.getOne((long) 2);
//        r.getParentId();
//        userService.getUserByEmployeenum("666666");
//        userRoleDao.getAll();
//        userService.deleteEntry("13131313");

    }

}
