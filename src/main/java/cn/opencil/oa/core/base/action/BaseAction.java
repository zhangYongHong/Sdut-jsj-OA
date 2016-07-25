package cn.opencil.oa.core.base.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Project Name:SdutOA
 * File Name:BaseAction.java
 * Date:2016-4-15下午1:29:03
 * Author : 王基伟
 *
 * Action类的通用实现类
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>,ServletRequestAware,ServletResponseAware{

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	

	Class entityClass;
	T t;
	/**
	 * 解析泛型
	 */
	public BaseAction(){
		Type superclass = this.getClass().getGenericSuperclass();
		ParameterizedType type = (ParameterizedType) superclass;
		Type[] args = type.getActualTypeArguments();
		entityClass = (Class) ((null != args && args.length > 0) ? args[0]
				: null);
		try {
			this.t = (T) entityClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public T getModel() {
		
		return this.t;
	}
	
	public HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	
	private int currentPage = 1;
	
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public static final String LISTACTION = "listAction";//跳转到列表页面的字符串
	public static final String ACTIONRACTION = "actionRaction";//action重定向到action
	public static final String ACTION2ACTION = "action2action";//action跳转到action
	public static final String ADDUI = "addUI";//跳转到添加页面
	public static final String UPDATEUI = "updateUI";//挑战到更新页面

	public String listAction = LISTACTION;
	public String action2action = ACTION2ACTION;
	public String actionRaction = ACTIONRACTION;
	public String addUI = ADDUI;
	public String updateUI = UPDATEUI;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {

		this.response = response;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}
}
