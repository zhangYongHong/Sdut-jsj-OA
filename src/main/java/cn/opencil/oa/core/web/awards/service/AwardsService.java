package cn.opencil.oa.core.web.awards.service;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.service.BaseService;
import cn.opencil.oa.core.domain.Awards;
import cn.opencil.oa.core.query.BaseQuery;

import java.io.InputStream;

/**
 * Project Name:SdutOA
 * File Name:AwardsService.java
 * Date:2016-4-15下午1:37:01
 * Author : 张树伟
 * <p>
 * 获奖管理的serive
 */
public interface AwardsService extends BaseService<Awards> {

    PageResult<Awards> getAwardsPageResult(BaseQuery baseQuery);

    void addAwards(Awards awards);

    void startProcess(Long id);

    String getAnnex(Long id);

    InputStream showAnnex(Long id);

    void deleteAwards(Long aid);

    void updateAwards(Awards model);

    Awards downloadImage(Long aid);

    Awards downloadZip(String schoolYear) throws Exception;

    InputStream exportExcel(String schoolYear);

    String getExcelName(String schoolYear);
}
