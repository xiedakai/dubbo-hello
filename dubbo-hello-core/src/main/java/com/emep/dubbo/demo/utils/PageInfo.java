package com.emep.dubbo.demo.utils;

import java.io.Serializable;

public class PageInfo implements Serializable {

	private static final long serialVersionUID = 587754556498974978L;

	private Integer rows = 10;
	private Integer totalPage = 0;
	private Integer totalResult = 0;
	private Integer page = 1;
	private Integer currentResult = 0;
	private String sortField;
	private String order;

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		if (null == rows)
			this.rows = 10;
		else
			this.rows = rows;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(Integer totalResult) {
		this.totalResult = totalResult;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		if (null == page)
			this.page = 1;
		else
			this.page = page;
	}

	public Integer getCurrentResult() {
		return (page - 1) * rows;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
