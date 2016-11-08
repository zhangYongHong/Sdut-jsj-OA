package cn.opencil.oa.core.web.Awards;

import cn.opencil.oa.core.domain.Awards;
import cn.opencil.oa.core.web.awards.service.AwardsService;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created with Sdut-jsj-OA.
 * Package: cn.opencil.oa.core.web.Awards
 * User: 张树伟
 * Date: 16-11-7
 * Time: 下午10:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:cn/opencil/oa/core/spring/applicationContext-*.xml")
public class AwardsServiceTest {
    @Autowired
    AwardsService awardsService;
    @Test
    public void test() {
        File srcFile = new File("/home/mnzero/IDEAWorkspace/S2SH/Sdut-jsj-OA/src/main/webapp/header.jsp");
        Awards awards = new Awards();
        awards.setAnnexFile(srcFile);
        awards.setAid((long) 111111);
        awardsService.addAwards(awards);
    }

    @Test
    public void fileTest() {
        File srcFile = new File("/home/mnzero/IDEAWorkspace/S2SH/Sdut-jsj-OA/src/main/webapp/images/apple-touch-icon-57-precomposed.png");
        String name = srcFile.getName();
        if (!name.endsWith(".png"))
            System.out.println("不合法");
        else {
//            String path = ServletActionContext.getServletContext().getContextPath();
            String path = "/home/mnzero/IDEAWorkspace/S2SH/Sdut-jsj-OA";
            String pathOut = path + "/src/main/webapp/upload/images/";
            String fileName = UUID.randomUUID() + ".png";
            File tempFile = new File(pathOut + fileName);
            try {
                FileUtils.copyFile(srcFile, tempFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
