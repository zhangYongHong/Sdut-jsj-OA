package cn.opencil.oa.core.web.paper.service.impl;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.common.util.ExcelFileGeneratorUtil;
import cn.opencil.oa.common.util.PageUtil;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.QuestionPaper;
import cn.opencil.oa.core.query.BaseQuery;
import cn.opencil.oa.core.query.PaperQuery;
import cn.opencil.oa.core.web.basedata.service.SystemDDLService;
import cn.opencil.oa.core.web.excel.service.ExcelService;
import cn.opencil.oa.core.web.paper.dao.QPDao;
import cn.opencil.oa.core.web.paper.service.QPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Project Name:SdutOA
 * File Name:QPServiceImpl.java
 * Date:2016-4-19下午9:34:18
 * Author : 张树伟
 */
@Service
public class QPServiceImpl extends BaseServiceImpl<QuestionPaper> implements
        QPService {

    @Autowired
    private QPDao qpDao;
    @Autowired
    private ExcelService excelService;
    @Autowired
    private SystemDDLService systemDDLService;

    @Override
    public BaseDao getBaseDao() {
        return qpDao;
    }

    @Override
    public ArrayList<String> getFieldDataNameExcel() {
        return excelService.getExcelByQPaper();
    }

    private ArrayList<ArrayList<String>> getFieldDataExcel(BaseQuery baseQuery) {

        Collection<QuestionPaper> entrys = this.qpDao
                .getEntrysByQuery(baseQuery);
        List<QuestionPaper> qps = new ArrayList<>(entrys);
        ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();

        if (null != entrys && qps.size() > 0) {
            for (int i = 0; i < qps.size(); i++) {

                QuestionPaper qp = qps.get(i);
                ArrayList<String> oneData = new ArrayList<String>();

                oneData.add("" + (i + 1));
                oneData.add(qp.getTeacher());
                oneData.add(qp.getClassName());
                oneData.add(qp.getCourse());
                oneData.add(PageUtil.getPsourceToString(qp.getPsource()));
                oneData.add(PageUtil.getExaminewayToString(qp.getExamineway()));
                oneData.add(qp.getNum() + "");
                oneData.add(qp.getPnum() + "");
                oneData.add((qp.getAnalyzes() == 1) ? "有" : "无");
                oneData.add((qp.getPlan() == 1) ? "有" : "无");
                oneData.add((qp.getInvigilation() == 1) ? "有" : "无");
                oneData.add((qp.getAb() == 1) ? "有" : "无");
                oneData.add((qp.getAnswer() == 1) ? "有" : "无");
                oneData.add((qp.getStandard() == 1) ? "有" : "无");
                oneData.add((qp.getScore() == 1) ? "有" : "无");
                oneData.add(qp.getComment());
                oneData.add(qp.getFileNum());
                datas.add(oneData);
            }
        }
        return datas;
    }

    public PageResult<QuestionPaper> getPageResultForQP(BaseQuery baseQuery) {
        PageResult<QuestionPaper> paperPageResult = null;
        paperPageResult = qpDao.getPageResult(baseQuery);
        List paperList = paperPageResult.getRows();
        PageUtil.sortListForQP(paperList);
        return paperPageResult;
    }

    @Override
    public void uploadExcel(File uploadfile, String schoolYear) {
        if (null != uploadfile) {
//			String schoolYear = DateUtil.groupSchoolYear();
            List<QuestionPaper> list = ExcelFileGeneratorUtil.getQuerionPaperForExcel(uploadfile);
            String fileNum = "";

            for (QuestionPaper qp : list) {
                fileNum = PageUtil.getFileNum(qp.getClassName());
                qp.setFileNum(fileNum);
                qp.setSchoolYear(schoolYear);
                this.addEntry(qp);
            }
        }
    }

    @Override
    public InputStream exportExcel(String schoolYear) {
        PaperQuery qpQuery = new PaperQuery();
        qpQuery.setSchoolYear(schoolYear);
        ArrayList<String> fieldDataName = this.getFieldDataNameExcel();
        ArrayList<ArrayList<String>> fieldDatas = this.getFieldDataExcel(qpQuery);
        if (fieldDatas.size() == 0) {
            return null;
        }
        ExcelFileGeneratorUtil excelFileGenerator = new ExcelFileGeneratorUtil(
                fieldDataName, fieldDatas);
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

    @Override
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

    private String getTitle(String schoolYear) {
        String year = systemDDLService.getSystenDDL("schoolYear", Integer.parseInt(schoolYear)).getDdlName();
        return year +"-试题归档汇总表";
    }
}
