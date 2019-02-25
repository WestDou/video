package com.zc.domain.util;
/** 
 * @Description: TODO
 * @author: zhangcheng
 * @date: 2019年2月15日 
 */

import java.util.List;

public class PageVO {
	
	private int pageNum;
	private Long total;
	private int pages;
	private List<?> list;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	
	

}
