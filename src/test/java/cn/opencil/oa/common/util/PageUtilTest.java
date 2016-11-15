package cn.opencil.oa.common.util;

import org.junit.Test;

import java.io.File;

/**
 * Created with Sdut-jsj-OA.
 * Package: cn.opencil.oa.common.util
 * User: 张树伟
 * Date: 16-11-15
 * Time: 下午1:49
 */
public class PageUtilTest {
    @Test
    public void zipTest() {
        File file = new File("/home/mnzero/IDEAWorkspace/S2SH/Sdut-jsj-OA/src/main/webapp/upload/zip/211");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            PageUtil.deCompress(new File("/home/mnzero/IDEAWorkspace/S2SH/Sdut-jsj-OA/src/main/webapp/upload/images"),
                    "/home/mnzero/IDEAWorkspace/S2SH/Sdut-jsj-OA/src/main/webapp/upload/zip/211/211.zip");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
