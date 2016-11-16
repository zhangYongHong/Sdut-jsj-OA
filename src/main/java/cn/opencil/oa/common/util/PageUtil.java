package cn.opencil.oa.common.util;

import cn.opencil.oa.core.domain.Awards;
import cn.opencil.oa.core.domain.BasePaper;
import cn.opencil.oa.core.domain.Role;
import cn.opencil.oa.core.domain.User;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by mnzero on 16-7-23.
 */
public class PageUtil {

    /**
     * 根据授课班级确定对应的专业和年纪组成橱窗归档号
     *
     * @param className
     * @return
     */
    public static String getFileNum(String className) {
        String regex = "([\\u4e00-\\u9fa5]+)([0-9]{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(className);
        String fileNum = "";
        while (matcher.find()) {
            fileNum = matcher.group();
        }
        return fileNum;
    }

    /**
     * 对实训或试卷的信息进行排序，使已修改的信息在后边
     */
    public static void sortListForQP(List<BasePaper> list) {
        BasePaper temp;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size(); j++)
                if (list.get(j - 1).getIsChange().equals("已修改")
                        && list.get(j).getIsChange().equals("未修改")) {
                    temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                }
        }
    }

    /**
     * 获取examineway将其转换为对应的String值
     */
    public static String getExaminewayToString(int examineway) {
        String examinewayView = "";
        switch (examineway) {
            case 1:
                examinewayView = "开卷";
                break;
            case 2:
                examinewayView = "闭卷";
                break;
            case 3:
                examinewayView = "答辩";
                break;
            case 4:
                examinewayView = "大作业";
                break;
            case 5:
                examinewayView = "上机";
                break;

            default:
                examinewayView = "";
                break;
        }
        return examinewayView;
    }

    /**
     * 获取Psource将其转换为对应的String值
     */
    public static String getPsourceToString(int psource) {
        String psourceView;
        switch (psource) {
            case 1:
                psourceView = "自拟";
                break;
            case 2:
                psourceView = "统一命题";
                break;
            default:
                psourceView = "";
                break;
        }
        return psourceView;
    }

    /**
     * 获取String值将其转换为对应的Psource
     */
    public static int getStringToPsource(String str) {
        if (str.equals("开卷")) {
            return 1;
        } else if (str.equals("闭卷")) {
            return 2;
        } else if (str.equals("答辩")) {
            return 3;
        } else if (str.equals("大作业")) {
            return 4;
        } else if (str.equals("上机")) {
            return 5;
        } else {
            return 2;
        }
    }

    public static int getStringToExamineway(String str) {
        if (str.equals("自拟")) {
            return 1;
        } else if (str.equals("统一命题")) {
            return 2;
        } else {
            return 2;
        }
    }

    /**
     * 对获奖管理的信息进行排序
     */
    public static List<Awards> sortAwards(List<Awards> list) {
        Awards temp;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i).getLevel() > list.get(j).getLevel()) {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                } else if (list.get(i).getLevel() == list.get(j).getLevel()) {
                    //若获奖级别相同时按照获奖等级排序
                    if (list.get(i).getGrade() > list.get(j).getGrade()) {
                        temp = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, temp);
                    }
                }
            }
        }
        for (int k = 0; k < list.size(); k++) {
            list.get(k).setId(k + 1);
        }
        return list;
    }

    /**
     * 获取字符串按照逗号进行分割
     */
    public static List<String> getStringList(String str) {
        List<String> list = new ArrayList<>();
        List listNum = new ArrayList();
        int start = 0, end;
        if (str != null && str.length() > 1) {
            for (int i = 0; i < str.toCharArray().length; i++) {
                if (str.charAt(i) == '，' || str.charAt(i) == ',') {
                    listNum.add(i);
                }
            }
            if (listNum.size() != 0) {
                for (int i = 0; i < listNum.size() + 1; i++) {
                    if (i != listNum.size()) {
                        end = (int) listNum.get(i);
                        list.add(str.substring(start, end));
                        start = end + 1;
                    } else {
                        list.add(str.substring(start, str.length()));
                    }
                }
            }
        } else {
            list.add(str);
        }
        return list;
    }

    /**
     * 将获奖管理中获取的list中的每条数据按照其中学生姓名的个数来扩充。
     */
    public static List<Awards> getListByStuname(List<Awards> list) {
        List<String> stuNameList; //姓名列表
        List<String> specialtyList; //专业列表
        List<String> classesList; //班级列表

        List<Awards> awardsList = new ArrayList<>();
        Awards awards;
        for (int i = 0; i < list.size(); i++) {
            stuNameList = getStringList(list.get(i).getStuname());
            specialtyList = getStringList(list.get(i).getSpecialty());
            classesList = getStringList(list.get(i).getClasses());
            if (0 != stuNameList.size()) {
                for (int j = 0; j < stuNameList.size(); j++) {
                    awards = list.get(i).clone();
                    awards.setStuname(stuNameList.get(j));
                    awards.setSpecialty(specialtyList.get(j));
                    awards.setClasses(classesList.get(j));
                    awards.setIdView(awards.getId() + "-" + (j + 1));
                    awardsList.add(awards);
                }
            } else {
                awards = list.get(i);
                awards.setIdView(awards.getId() + "-1");
                awardsList.add(awards);
            }
        }
        return awardsList;
    }

    /**
     * 获取文件名后缀
     */
    public static String getExtension(String fileName) {
        int temp = fileName.indexOf('.');
        String extension = fileName.substring(temp + 1, fileName.length());
        return extension;
    }

    public static User getUser() {
        User user = (User) ActionContext.getContext().getSession().get(ContantKey.GLOBLE_USER_INFO);
        return user;
    }

    public static HttpSession getHttpSession() {
        return ServletActionContext.getRequest().getSession();
    }

    public static List<Long> strListTOLongList(List<String> stringList) {
        if (stringList != null && stringList.size() > 0) {
            if (stringList.get(0) != null) {
                List<Long> longs = new ArrayList<>();
                for (String str : stringList) {
                    longs.add(Long.parseLong(str));
                }
                return longs;
            }
            return null;
        }
        return null;
    }

    public static void removeSpaces(Role role) {
        String str = role.getResourceIdsStr();
        role.setResourceIdsStr(str.replaceAll(" ", ""));
    }

    public static String  uploadAnnex(File srcFile, String schoolYear, String achievement) {
        String path = ServletActionContext.getServletContext().getRealPath("/upload/images/" + schoolYear) + "/";
        String fileName = achievement + ".jpeg";
        File tempFile = new File(path + fileName);
        try {
            FileUtils.copyFile(srcFile, tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path + fileName;
    }
    /**
     * 文档压缩
     */
    public final static void deCompress(File file, String dest) throws Exception {
        String zipPath = ServletActionContext.getServletContext().getRealPath("/upload/zip/");
        File test = new File(zipPath);
        if (!test.exists())
            test.mkdirs();
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest))) {
            zipFile(file, zos, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final static void zipFile(File inFile, ZipOutputStream zos, String dir) throws IOException {
        if (inFile.isDirectory()) {
            File[] files = inFile.listFiles();
            if (files.length > 0) {
                for (File file : files) {
                    String name = inFile.getName();
                    if (!"".equals(dir)) {
                        name = dir + "/" + name;
                    }
                    zipFile(file, zos, name);
                }
            }
        } else {
            String entryName = null;
            if (!"".equals(dir)) {
                entryName = dir + "/" + inFile.getName();
            } else {
                entryName = inFile.getName();
            }
            ZipEntry entry = new ZipEntry(entryName);
            zos.putNextEntry(entry);
            try (InputStream is = new FileInputStream(inFile)) {
                int len = 0;
                while ((len = is.read()) != -1) {
                    zos.write(len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}