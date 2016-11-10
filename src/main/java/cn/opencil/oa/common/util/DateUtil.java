package cn.opencil.oa.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Project Name:SdutOA
 * File Name:DateUtil.java
 * Date:2016-4-17下午3:57:06
 * Author : 王基伟
 * 日期转换工具类
 */
public class DateUtil {

	/**
	 * 将日期格式转换为 201604 格式
	 * @param date
	 * @return
	 */
	public static String dateToYearMon(Date date){
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
		String format = sd.format(date);
		return format;
	}
	
	public static String dateToYear(Date date){
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy");
		String format = sd.format(date);
		return format;
	}
	
	public static String dateToYMD(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String str = dateFormat.format(new Date());
		return str;
	}

	//根据excel上传的时间来确定学年与学期信息
	public static String groupSchoolYear() {
		Calendar now = Calendar.getInstance();
		int nowYears = now.get(Calendar.YEAR);
		int nowMonth = now.get(Calendar.MONTH);
		int oldYears = nowYears - 1;
		StringBuffer yearBuffer = new StringBuffer();
		yearBuffer.append(oldYears);
		yearBuffer.append("-");
		yearBuffer.append(nowYears);
		yearBuffer.append("-");
		if (nowMonth >= 1 && nowMonth <= 6)
			yearBuffer.append("1");//第一学期
		if (nowMonth >= 7 && nowMonth <= 12)
			yearBuffer.append("2");//第二学期
		String schoolYear = yearBuffer.toString();
		return schoolYear;
	}

	public static long getDate() {
		return new Date().getTime();
	}
}
