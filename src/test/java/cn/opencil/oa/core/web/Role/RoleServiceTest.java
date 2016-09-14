package cn.opencil.oa.core.web.Role;

import cn.opencil.oa.core.web.role.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by mnzero on 16-9-14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:cn/opencil/oa/core/spring/applicationContext-*.xml")
public class RoleServiceTest {
    @Autowired
    RoleService roleService;

    @Test
    public void testGetRoleName() {
        Long[] longs = {Long.valueOf(1)};
        System.out.println(roleService.getRoleName(longs));
    }
}
