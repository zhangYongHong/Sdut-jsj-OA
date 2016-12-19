package cn.opencil.oa.core.web.test.service.impl;

import cn.opencil.oa.common.util.ExcelFileGeneratorUtil;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.impl.BaseServiceImpl;
import cn.opencil.oa.core.domain.Topics;
import cn.opencil.oa.core.query.PaperQuery;
import cn.opencil.oa.core.web.basedata.service.SystemDDLService;
import cn.opencil.oa.core.web.excel.service.ExcelService;
import cn.opencil.oa.core.web.test.dao.TopicsDao;
import cn.opencil.oa.core.web.test.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with Sdut-jsj-OA.
 * Package: cn.opencil.oa.core.web.test.service.impl
 * User: 张树伟
 * Date: 16-12-19
 * Time: 下午3:11
 */
@Service
public class TopicsServiceImpl extends BaseServiceImpl<Topics> implements TopicsService {
    @Autowired
    private TopicsDao topicsDao;
    @Autowired
    private SystemDDLService systemDDLService;
    @Autowired
    private ExcelService excelService;

    @Override
    public BaseDao getBaseDao() {
        return topicsDao;
    }

    @Override
    public InputStream exportExcel(String schoolYear) {
        PaperQuery paperQuery = new PaperQuery();
        paperQuery.setSchoolYear(schoolYear.toString());
        ArrayList<String> fieldDataName = excelService.getExcelByTopics();
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

        List<Topics> entrys = this.topicsDao.getPageResult(baseQuery).getRows();
        ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();

        if (null != entrys && entrys.size() > 0) {
            for (int i = 0; i < entrys.size(); i++) {

                Topics topics = entrys.get(i);
                ArrayList<String> oneData = new ArrayList<String>();

                oneData.add("" + (i + 1));
                oneData.add(topics.getName());
                oneData.add(topics.getType());
                oneData.add(topics.getPrincipal());
                oneData.add(topics.getMember());
                oneData.add(topics.getStartTime().toString());
                oneData.add(topics.getEndTime().toString());
                oneData.add(topics.getEvaluate());
                oneData.add(topics.getGradation());
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

    private String getTitle(String schoolYear) {
        String year = systemDDLService.getSystenDDL("schoolYear", Integer.parseInt(schoolYear)).getDdlName();
        return year + "-教研课题汇总表";
    }
}
