package cn.opencil.oa.core.web.awards.service.impl;


import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.PasswordHelper;
import cn.opencil.oa.core.domain.Awards;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.query.UserQuery;
import cn.opencil.oa.core.web.awards.service.AwardsService;
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
    @Autowired
    private AwardsService awardsService;

    @Test
    public void passwordTest() {
        UserQuery userQuery = new UserQuery();
        PageResult<User> pageResult = userService.getUserPageResult(userQuery);
        List<User> users = pageResult.getRows();
        for (User user : users) {
            System.out.println("id:" +user.getUid()+ "　　工号："+ user.getEmployeenum() + "  密码："+ user.getPassword());
            user.setRoleIdsStr("2");
            user.setRole("普通教师");
            userService.updateEntry(user);
        }
    }

    @Test
    public void addTest() {
        Awards awards = new Awards();
        awards.setClasses("软件1402,软件1403,软件1404");
        awards.setSpecialty("软件, 软件, 软件");
        awards.setCompetitionid(1);
        awards.setLevel(1);
        awards.setGrade(1);
        awards.setState(2);
        awards.setStuname("wa, er, ee");
        awards.setTeacher("dddd");
        awards.setPrizeunit("山东理工大学");
        awards.setAtime("12222-22211-");
        awards.setSchoolYear("1");
        for (int i = 0; i < 10; i++) {
            awardsService.addEntry(awards);
        }
    }
}
