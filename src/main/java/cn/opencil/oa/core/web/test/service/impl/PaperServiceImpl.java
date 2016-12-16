package cn.opencil.oa.core.web.test.service.impl;

import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.Paper;
import cn.opencil.oa.core.web.test.dao.PaperDao;
import cn.opencil.oa.core.web.test.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with Sdut-jsj-OA.
 * Package: cn.opencil.oa.core.web.test.service.impl
 * User: 张树伟
 * Date: 16-11-28
 * Time: 下午5:12
 */
@Service
public class PaperServiceImpl extends BaseServiceImpl<Paper> implements PaperService {
    @Autowired
    private PaperDao paperDao;

    @Override
    public BaseDao getBaseDao() {
        return paperDao;
    }
}
