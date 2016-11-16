package cn.opencil.oa.core.web.awards.service.impl;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.Awards;
import cn.opencil.oa.core.domain.SystemDDL;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.query.BaseQuery;
import cn.opencil.oa.core.web.activiti.service.ActivitiService;
import cn.opencil.oa.core.web.awards.dao.AwardsDao;
import cn.opencil.oa.core.web.awards.service.AwardsService;
import cn.opencil.oa.core.web.basedata.service.SystemDDLService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * Project Name:SdutOA
 * File Name:AwardsServiceImpl.java
 * Date:2016-4-15下午1:38:01
 * Author : 张树伟
 */
@Service
public class AwardsServiceImpl extends BaseServiceImpl<Awards> implements AwardsService {

    @Autowired
    private AwardsDao awardsDao;
    @Autowired
    private SystemDDLService systemDDLService;
    @Autowired
    private ActivitiService activitiService;

    @Override
    public BaseDao getBaseDao() {
        return this.awardsDao;
    }

    public void addAwards(Awards awards) throws DataException {
        String achievement = awards.getAchievement();
        String path = PageUtil.uploadAnnex(awards.getAnnexFile(), awards.getSchoolYear(), achievement);
        if (path != null) {
            User user = PageUtil.getUser();
            awards.setFileNum(PageUtil.getFileNum(awards.getClasses()));
            awards.setEmployeenum(user.getEmployeenum());
            awards.setAnnex(path);
            super.addEntry(awards);
        }
    }

    @Override
    public PageResult<Awards> getAwardsPageResult(BaseQuery baseQuery) {
        PageResult<Awards> awardsPageResult = null;
        SystemDDL systemDDL;
        try {
            awardsPageResult = this.awardsDao.getAwaPageResult(baseQuery);
            List<Awards> awardses = awardsPageResult.getRows();
            for (int i = 0; i < awardses.size(); i++) {
                Awards awards = awardses.get(i);
                systemDDL = systemDDLService.getSystenDDL("competitionView", awards.getCompetitionid());
                if (systemDDL != null)
                    awards.setCompetitionView(systemDDL.getDdlName());
                else
                    awards.setCompetitionView("");
            }
            //对获奖信息按照获奖级别、获奖等级排序
            PageUtil.sortAwards(awardses);
            awardsPageResult.setRows(PageUtil.getListByStuname(awardses));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return awardsPageResult;
    }

    @Override
    public void startProcess(Long id) {
        Awards awards = awardsDao.getEntryById(id);
        User user = PageUtil.getUser();
        if (awards != null) {
            awards.setState(1);
            awardsDao.updateEntry(awards);
            //获取业务对象的类名作为key
            String processDefinitionKey = awards.getClass().getSimpleName();
            String businessKey = processDefinitionKey + ":" + id.toString();
            //设置流程变量
            HashMap<String, Object> value = new HashMap<>();
            //classType: 业务对象类型
            //objId:业务ID
            value.put("inputUser", user.getUserName());
            value.put("classType", processDefinitionKey);
            value.put("objId", awards.getAid());
            //业务对象与流程建立关系
            activitiService.start(processDefinitionKey, businessKey, value);
        }
    }

    @Override
    public String getAnnex(Long id) {
        return awardsDao.getEntryById(id).getAnnex();
    }

    @Override
    public InputStream showAnnex(Long id) {
        try {
            return new FileInputStream(new File(getAnnex(id)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteAwards(Long aid) {
        if (getAnnex(aid) != null) {
            try {
                FileUtils.forceDelete(new File(getAnnex(aid)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        awardsDao.deleteEntry(aid);
    }

    @Override
    public void updateAwards(Awards model) {
        if (model.getState() == null || model.getState() != 3) {
            if (model.getAnnexFile() != null) {
                String achievement = model.getAchievement();
                String path = PageUtil.uploadAnnex(model.getAnnexFile(), model.getSchoolYear(), achievement);
                if (path != null)
                    model.setAnnex(path);
            }
        } else {
            if (model.getAnnex() != null)
                try {
                    FileUtils.forceDelete(new File(model.getAnnex()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        awardsDao.updateEntry(model);
    }

    @Override
    public Awards downloadImage(Long aid) {
        Awards awards = awardsDao.getEntryById(aid);
        SystemDDL systemDDL = systemDDLService.getSystenDDL("competitionView", awards.getCompetitionid());
        awards.setCompetitionView(systemDDL.getDdlName());
        String annex = awards.getAnnex();
        File file = new File(annex);
        try {
            awards.setInputStream(new FileInputStream(file));
            return awards;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Awards downloadZip(String schoolYear) throws Exception {
        String path = ServletActionContext.getServletContext().getRealPath("/upload/images/" + schoolYear);
        File file = new File(path);
        String zipPath = ServletActionContext.getServletContext().getRealPath("/upload/zip/" + schoolYear + ".zip");
        PageUtil.deCompress(file, zipPath);
        InputStream inputStream = new FileInputStream(zipPath);
        Awards awards = new Awards();
        awards.setInputStream(inputStream);
        return awards;
    }

    @Override
    public void exportExcel() {

    }
}
