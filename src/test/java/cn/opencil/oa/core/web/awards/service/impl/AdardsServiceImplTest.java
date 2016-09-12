package cn.opencil.oa.core.web.awards.service.impl;


import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.PasswordHelper;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.query.UserQuery;
import cn.opencil.oa.core.web.basedata.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by mnzero on 16-7-26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:cn/opencil/oa/core/spring/applicationContext-*.xml")
public class AdardsServiceImplTest {
    @Autowired
    private PasswordHelper passwordHelper;
    @Autowired
    private UserService userService;

    @Test
    public void passwordTest() {
        UserQuery userQuery = new UserQuery();
        PageResult<User> pageResult = userService.getUserPageResult(userQuery);
        List<User> users = pageResult.getRows();
        for (User user : users) {
            System.out.println("id:" +user.getUid()+ "　　工号："+ user.getEmployeenum() + "  密码："+ user.getPassword());
            user.setPassword("000000");
            passwordHelper.encryptPassword(user);
            userService.updateEntry(user);
        }
    }
}
