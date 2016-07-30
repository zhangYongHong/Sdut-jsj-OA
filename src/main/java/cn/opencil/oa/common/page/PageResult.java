package cn.opencil.oa.common.page;

import java.io.Serializable;
import java.util.List;

/**
 * Project Name:SdutOA
 * File Name:PageResult.java
 * Date:2016-4-15下午1:18:30
 * Author : 王基伟
 *
 * 分页类
 */
public class PageResult<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private int currentPage;
	// 一页显示的条数
	private int pageSize;
	// 总条数
	private int totalRows;
	// 总页数:计算出来
	private int totalPages;
	// 当前页的数据
	private List<T> rows;

	public PageResult() {
	}

	public PageResult(int currentPage, int pageSize, int totalRows) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalRows = totalRows;
		//当前页不能为负
		this.currentPage = Math.max(this.currentPage, 1);
		this.pageSize = Math.max(this.pageSize, 1);
		// 总页数:计算出来
		this.totalPages = (this.totalRows + this.pageSize - 1) / this.pageSize;

		this.currentPage = Math.min(this.currentPage, this.totalPages);

	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	
}
