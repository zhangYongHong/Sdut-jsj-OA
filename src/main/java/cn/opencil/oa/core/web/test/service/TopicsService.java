package cn.opencil.oa.core.web.test.service;

import cn.opencil.oa.core.base.service.BaseService;
import cn.opencil.oa.core.domain.Topics;

import java.io.InputStream;

/**
 * Created with Sdut-jsj-OA.
 * Package: cn.opencil.oa.core.web.test.service
 * User: 张树伟
 * Date: 16-12-19
 * Time: 下午3:10
 */
public interface TopicsService extends BaseService<Topics> {
    InputStream exportExcel(String schoolYear);

    String getExcelName(String schoolYear);
}
