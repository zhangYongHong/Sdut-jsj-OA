package cn.opencil.oa.common.util;

import cn.opencil.oa.core.domain.QuestionPaper;
import cn.opencil.oa.core.domain.TrainingPaper;
import cn.opencil.oa.core.web.paper.service.impl.QPServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Name:SdutOA
 * File Name:ExcelFileGeneratorUtil.java
 * Date:2016-4-17下午1:07:45
 * Author : 王基伟
 * excel文件生成  工具类
 */
public class ExcelFileGeneratorUtil {
    private static final Log log = LogFactory.getLog(QPServiceImpl.class);

    private final int SPLIT_COUNT = 15; //Excel每个sheet的行数

    private ArrayList<String> fieldName = null; //excel列名

    private ArrayList<ArrayList<String>> fieldData = null; //excel数据内容

    private HSSFWorkbook workBook = null;
    private String title;//excel标题

    /**
     * 构造器
     *
     * @param fieldName 结果集的字段名
     */
    public ExcelFileGeneratorUtil(ArrayList<String> fieldName, ArrayList<ArrayList<String>> fieldData) {

        this.fieldName = fieldName;
        this.fieldData = fieldData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * 读取QuerionPaperexcel中信息到List
     *
     * @param f 文件名称
     * @return 返回实体集合
     */
    public static List<QuestionPaper> getQuerionPaperForExcel(File f) {
        List list = null;//返回对象

        File file = f;

        String filename = file.getName();
        if (filename == null || "".equals(filename)) {
            log.error("导入excel文件不存在！");
        }
        try {
            InputStream input = new FileInputStream(file);
            Workbook workBook = null;

            workBook = new HSSFWorkbook(new FileInputStream(file));

            HSSFSheet sheet = (HSSFSheet) workBook.getSheetAt(0);
            if (sheet != null) {      //list
                list = new ArrayList();
                for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {   //object
                    HSSFRow row = sheet.getRow(i);
                    QuestionPaper qp = new QuestionPaper();
                    for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {   //column
                        HSSFCell cell = row.getCell(j);
                        switch (j) {
                            case 0:
                                break;
                            case 1:
                                if (cell != null) {
                                    qp.setTeacher(cell.toString());
                                } else {
                                    qp.setTeacher("");
                                }
                                break;
                            case 2:
                                if (cell != null) {
                                    qp.setClassName(cell.toString());
                                } else {
                                    qp.setClassName("");
                                }
                                break;
                            case 3:
                                if (cell != null) {
                                    qp.setCourse(cell.toString());
                                } else {
                                    qp.setCourse("");
                                }
                                break;
                            case 4:
                                int psource = PageUtil.getStringToPsource(cell.toString());
                                qp.setPsource(psource);
                                break;
                            case 5:
                                int examineway = PageUtil.getStringToExamineway(cell.toString());
                                qp.setExamineway(examineway);
                                break;
                            case 6:
                                if (cell.toString().equals("") || cell.toString() != null) {
                                    String temp = cell.toString().substring(0, cell.toString().length() - 2);
                                    Integer tempInt = Integer.valueOf(temp);
                                    qp.setNum(tempInt);
                                } else {
                                    qp.setNum(0);
                                }
                                break;
                            case 7:
                                if (cell != null) {
                                    qp.setPnum(Integer.getInteger(cell.toString()));
                                } else {
                                    qp.setPnum(0);
                                }
                                break;
                            case 8:
                                if (cell.toString().equals("有")) {
                                    qp.setAnalyzes(1);
                                } else {
                                    qp.setAnalyzes(0);
                                }
                                break;
                            case 9:
                                if (cell.toString().equals("有")) {
                                    qp.setPlan(1);
                                } else {
                                    qp.setPnum(0);
                                }
                                break;
                            case 10:
                                if (cell.toString().equals("有")) {
                                    qp.setInvigilation(1);
                                } else {
                                    qp.setInvigilation(0);
                                }
                                break;
                            case 11:
                                if (cell.toString().equals("有")) {
                                    qp.setAb(1);
                                } else {
                                    qp.setAb(0);
                                }
                                break;
                            case 12:
                                if (cell.toString().equals("有")) {
                                    qp.setAnswer(1);
                                } else {
                                    qp.setAnswer(0);
                                }
                                break;
                            case 13:
                                if (cell.toString().equals("有")) {
                                    qp.setStandard(1);
                                } else {
                                    qp.setStandard(0);
                                }
                                break;
                            case 14:
                                if (cell.toString().equals("有")) {
                                    qp.setScore(1);
                                } else {
                                    qp.setScore(0);
                                }
                                break;
                            case 15:
                                if (cell != null) {
                                    qp.setComment(cell.toString());
                                } else {
                                    qp.setComment("");
                                }
                                break;
                            case 16:
                                qp.setFileNum("");
                                break;
                            case 17:
                                qp.setSchoolYear("");
                                break;
                        }
                    }
                    if (row.getPhysicalNumberOfCells() < 15) {
                        qp.setComment("");
                        qp.setFileNum("");
                        qp.setSchoolYear("");
                    }
                    qp.setIsChange("未修改");
                    list.add(qp);
                    log.info("当前excel总条数" + list.size());
                }
            }
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<TrainingPaper> getTrainingPaperForExcel(File f) {
        List list = null;//返回对象

        File file = f;

        String filename = file.getName();
        if (filename == null || "".equals(filename)) {
            log.error("导入excel文件不存在！");
        }
        try {
            InputStream input = new FileInputStream(file);
            Workbook workBook = null;

            workBook = new HSSFWorkbook(new FileInputStream(file));

            HSSFSheet sheet = (HSSFSheet) workBook.getSheetAt(0);
            if (sheet != null) {      //list
                list = new ArrayList();
                for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {   //object
                    HSSFRow row = sheet.getRow(i);
                    TrainingPaper trainingPaper = new TrainingPaper();
                    for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {   //column
                        HSSFCell cell = row.getCell(j);
                        switch (j) {
                            case 0:
                                break;
                            case 1:
                                if (cell != null) {
                                    trainingPaper.setTeacher(cell.toString());
                                } else {
                                    trainingPaper.setTeacher("");
                                }
                                break;
                            case 2:
                                if (cell != null) {
                                    trainingPaper.setCourse(cell.toString());
                                } else {
                                    trainingPaper.setCourse("");
                                }
                                break;
                            case 3:
                                if (cell != null) {
                                    trainingPaper.setClassName(cell.toString());
                                } else {
                                    trainingPaper.setClassName("");
                                }
                                break;
                            case 4:
                                if (cell.toString().equals("自拟")) {
                                    trainingPaper.setPsource(1);
                                } else {
                                    trainingPaper.setPsource(2);
                                }
                                break;
                            case 5:
                                if (cell.toString().equals("答辩")) {
                                    trainingPaper.setExamineway(1);
                                }
                                break;
                            case 6:
                                if (cell.toString().equals("")) {
                                    String temp = cell.toString().substring(0, cell.toString().length() - 2);
                                    Integer tempInt = Integer.valueOf(temp);
                                    trainingPaper.setNum(tempInt);
                                } else {
                                    trainingPaper.setNum(0);
                                }
                                break;
                            case 7:
                                if (cell != null) {
                                    trainingPaper.setTnum(Integer.getInteger(cell.toString()));
                                } else {
                                    trainingPaper.setTnum(0);
                                }
                                break;
                            case 8:
                                if (cell != null) {
                                    trainingPaper.setNature(cell.toString());
                                } else {
                                    trainingPaper.setNature("");
                                }
                                break;
                            case 9:
                                if (cell.toString().equals("有")) {
                                    trainingPaper.setAnalyzes(1);
                                } else {
                                    trainingPaper.setAnalyzes(0);
                                }
                                break;
                            case 10:
                                if (cell.toString().equals("有")) {
                                    trainingPaper.setPlan(1);
                                } else {
                                    trainingPaper.setPlan(0);
                                }
                                break;
                            case 11:
                                if (cell.toString().equals("有")) {
                                    trainingPaper.setStandard(1);
                                } else {
                                    trainingPaper.setStandard(0);
                                }
                                break;
                            case 12:
                                if (cell.toString().equals("有")) {
                                    trainingPaper.setScore(1);
                                } else {
                                    trainingPaper.setScore(0);
                                }
                                break;
                            case 13:
                                if (cell != null) {
                                    trainingPaper.setComment(cell.toString());
                                } else {
                                    trainingPaper.setComment("");
                                }
                                break;
                        }
                    }
                    if (row.getPhysicalNumberOfCells() < 13) {
                        trainingPaper.setComment("");
                        trainingPaper.setFileNum("");
                        trainingPaper.setSchoolYear("");
                    }
                    trainingPaper.setIsChange("未修改");
                    list.add(trainingPaper);
                    log.info("当前excel总条数" + list.size());
                }
            }
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 创建HSSFWorkbook对象
     *
     * @return HSSFWorkbook
     */
    public HSSFWorkbook createWorkbook() {

        workBook = new HSSFWorkbook();//创建一个工作薄对象
        int rows = fieldData.size();//总的记录数
        int sheetNum = 1;           //指定sheet的页数


        for (int i = 1; i <= sheetNum; i++) {//循环2个sheet的值
            HSSFSheet sheet = workBook.createSheet("Page " + i);//使用workbook对象创建sheet对象

            HSSFRow r = sheet.createRow(0);
            HSSFCell c = r.createCell(0);
            HSSFCellStyle cs = c.getCellStyle();
            cs.setAlignment(HSSFCellStyle.ALIGN_CENTER);//左右居中
            cs.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中

            HSSFFont f = workBook.createFont();//创建字体对象
            f.setFontName("宋体");
            f.setFontHeightInPoints((short) 11);//设置字体大小
            cs.setFont(f);

            String titleName = this.getTitle();

            c.setCellValue(titleName);
            c.setCellStyle(cs);
            r.setHeightInPoints(25);//设置行的高度
            //设置列表标题
            for (int j = 0; j < fieldName.size(); j++) {//循环excel的标题
                HSSFCell cell = r.createCell(j);//使用行对象创建列对象，0表示第1列
                /**************对标题添加样式begin********************/

                //设置列的宽度/
                sheet.setColumnWidth(j, 6000);


                HSSFCellStyle cellStyle = workBook.createCellStyle();//创建列的样式对象

                /** 设置边框*/
                cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
                cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
                cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
                cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
                cellStyle.setWrapText(true);//自动换行
                cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//左右居中
                cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中

                HSSFFont font = workBook.createFont();//创建字体对象
                font.setFontName("宋体");
                font.setFontHeightInPoints((short) 10);//设置字体大小

                //字体加粗
                font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

                //字体颜色
                font.setColor(HSSFColor.BLACK.index);
                //如果font中存在设置后的字体，并放置到cellStyle对象中，此时该单元格中就具有了样式字体
                cellStyle.setFont(font);

                /**************对标题添加样式end********************/

                //添加样式
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                if (fieldName.get(j) != null) {
                    //将创建好的样式放置到对应的单元格中
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue(fieldName.get(j));//为标题中的单元格设置值
                } else {
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue("");
                }
            }
            //分页处理excel的数据，遍历所有的结果
            for (int k = 0; k < rows; k++) {
                HSSFRow row = sheet.createRow((short) (k + 1));//创建1行
                row.setHeightInPoints(25);//设置行的高度
                //分页处理，获取每页的结果集，并将数据内容放入excel单元格
                ArrayList<String> rowList = fieldData.get((i - 1) * SPLIT_COUNT + k);
                for (int n = 0; n < rowList.size(); n++) {//遍历某一行的结果
                    HSSFCell cell = row.createCell(n);//使用行创建列对象
                    //
                    HSSFCellStyle cellStyle = workBook.createCellStyle();//创建列的样式对象
                    /** 设置边框*/
                    cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
                    cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
                    cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
                    cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
                    cellStyle.setWrapText(true);//自动换行
                    cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//左右居中
                    cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
                    HSSFFont font = workBook.createFont();//创建字体对象
                    font.setFontName("宋体");
                    font.setFontHeightInPoints((short) 11);//设置字体大小
                    //字体颜色
                    font.setColor(HSSFColor.BLACK.index);
                    //如果font中存在设置后的字体，并放置到cellStyle对象中，此时该单元格中就具有了样式字体
                    cellStyle.setFont(font);
                    cell.setCellStyle(cellStyle);
                    //

                    if (rowList.get(n) != null) {
                        cell.setCellValue(rowList.get(n).toString());
                    } else {
                        cell.setCellValue("");
                    }
                }
            }
        }
        return workBook;
    }

    public void expordExcel(OutputStream os) throws Exception {
        workBook = createWorkbook();
        workBook.write(os);//将数据写到输出流中，用于文件的输出
        os.close();
    }
}