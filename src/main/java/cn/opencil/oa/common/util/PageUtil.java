package cn.opencil.oa.common.util;

import cn.opencil.oa.core.domain.Awards;
import cn.opencil.oa.core.domain.BasePaper;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j - 1).getLevel() > list.get(j).getLevel()) {
                    temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                } else if (list.get(j - 1).getLevel() == list.get(j).getLevel()) {
                    //若获奖级别相同时按照获奖等级排序
                    if (list.get(j - 1).getGrade() > list.get(j).getGrade()) {
                        temp = list.get(j - 1);
                        list.set(j - 1, list.get(j));
                        list.set(j, temp);
                    }
                }
            }

        }
        return list;
    }
}