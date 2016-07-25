package cn.opencil.oa.common.util;

import org.apache.struts2.ServletActionContext;

/**
 * Project Name:SdutOA
 * File Name:ValuestackUtil.java
 * Date:2016-4-18下午12:36:40
 * Author : 王基伟
 *
 */
public class ValuestackUtil {

	public static void push(Object obj){
		ServletActionContext.getContext().getValueStack().push(obj);
	}
	
}
