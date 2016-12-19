package cn.opencil.oa.core.web.test.service.impl;

import cn.opencil.oa.common.util.ExcelFileGeneratorUtil;
import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.Paper;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.query.PaperQuery;
import cn.opencil.oa.core.web.basedata.service.SystemDDLService;
import cn.opencil.oa.core.web.excel.service.ExcelService;
import cn.opencil.oa.core.web.test.dao.PaperDao;
import cn.opencil.oa.core.web.test.service.PaperService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private SystemDDLService systemDDLService;
    @Autowired
    private ExcelService excelService;

    @Override
    public BaseDao getBaseDao() {
        return paperDao;
    }

    @Override
    public void addPaper(Paper paper) {
        String achievement = paper.getTitle();
        String schoolYear = systemDDLService.getSystenDDL("schoolYear", Integer.parseInt(paper.getSchoolYear())).getDdlName();
        String path = PageUtil.uploadAnnex(paper.getAnnexFile(), schoolYear, achievement, "paper");
        if (path != null) {
            User user = PageUtil.getUser();
            paper.setAnnex(path);
            super.addEntry(paper);
        }
    }

    @Override
    public void updatePaper(Paper model) {
        if (model.getAnnex() != null)
            try {
                FileUtils.forceDelete(new File(model.getAnnex()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        if (model.getAnnexFile() != null) {
            String achievement = model.getTitle();
            String schoolYear = systemDDLService.getSystenDDL("schoolYear", Integer.parseInt(model.getSchoolYear())).getDdlName();
            String path = PageUtil.uploadAnnex(model.getAnnexFile(), schoolYear, achievement, "paper");
            if (path != null)
                model.setAnnex(path);
            super.updateEntry(model);
        }
    }

    @Override
    public InputStream exportExcel(String schoolYear) {
        PaperQuery paperQuery = new PaperQuery();
        paperQuery.setSchoolYear(schoolYear.toString());
        ArrayList<String> fieldDataName = excelService.getExcelByPaper();
        ArrayList<ArrayList<String>> fieldData = this.getFieldDataExcel(paperQuery);
        if (fieldData.size() == 0) {
            return null;
        }
        ExcelFileGeneratorUtil excelFileGenerator = new ExcelFileGeneratorUtil(fieldDataName, fieldData);
        String title = this.getTitle(schoolYear);
        String filename = this.getExcelName(schoolYear);
        excelFileGenerator.setTitle(title);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            excelFileGenerator.expordExcel(os);// 使用输出流，导出
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] buf = os.toByteArray();
        ByteArrayInputStream in = new ByteArrayInputStream(buf);
        return in;
    }

    private ArrayList<ArrayList<String>> getFieldDataExcel(PaperQuery baseQuery) {

        List<Paper> entrys = this.paperDao.getPageResult(baseQuery).getRows();
        ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();

        if (null != entrys && entrys.size() > 0) {
            for (int i = 0; i < entrys.size(); i++) {

                Paper paper = entrys.get(i);
                ArrayList<String> oneData = new ArrayList<String>();

                oneData.add("" + (i + 1));
                oneData.add(paper.getTitle());
                oneData.add(paper.getAuthor());
                oneData.add(paper.getParticpants());
                oneData.add(getDDL("searchLevel", paper.getLevel()));
                oneData.add(paper.getPublishedDate().toString());
                oneData.add(getDDL("type", paper.getType()));
                oneData.add(paper.getVolumePeriod());
                datas.add(oneData);
            }
        }
        return datas;
    }

    private String getDDL(String keyword, Integer integer) {
        return systemDDLService.getSystenDDL(keyword, integer).getDdlName();
    }

    public String getExcelName(String schoolYear) {
        String title = this.getTitle(schoolYear);
        String filename = title + ".xls";
        try {
            filename = new String(filename.getBytes("gbk"), "iso-8859-1");// 转换文件名编码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return filename;
    }

    @Override
    public InputStream showAnnex(String uuid) {
        try {
            Paper entryById = paperDao.getEntryById(uuid);
            String annex = entryById.getAnnex();
            return new FileInputStream(new File(annex));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Paper downloadImage(String uuid) {
        Paper paper = paperDao.getEntryById(uuid);
        String annex = paper.getAnnex();
        File file = new File(annex);
        try {
            paper.setInputStream(new FileInputStream(file));
            return paper;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getTitle(String schoolYear) {
        String year = systemDDLService.getSystenDDL("schoolYear", Integer.parseInt(schoolYear)).getDdlName();
        return year + "-教研论文汇总表";
    }
}
