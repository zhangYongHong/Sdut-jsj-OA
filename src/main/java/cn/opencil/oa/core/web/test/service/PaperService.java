package cn.opencil.oa.core.web.test.service;

import cn.opencil.oa.core.base.service.BaseService;
import cn.opencil.oa.core.domain.Paper;

import java.io.InputStream;

/**
 * Created with Sdut-jsj-OA.
 * Package: cn.opencil.oa.core.web.test.service
 * User: 张树伟
 * Date: 16-11-28
 * Time: 下午5:12
 */
public interface PaperService extends BaseService<Paper> {
    void addPaper(Paper paper);

    void updatePaper(Paper model);

    InputStream exportExcel(String schoolYear);

    String getExcelName(String schoolYear);

    InputStream showAnnex(String uuid);

    Paper downloadImage(String uuid);
}
