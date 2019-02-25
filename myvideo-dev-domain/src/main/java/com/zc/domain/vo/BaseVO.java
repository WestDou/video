package com.zc.domain.vo;

import java.io.Serializable;

/** 
 * @Description: 
 * @author: zhangcheng
 * @date: 2019年1月12日 
 */
public class BaseVO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BaseVO(Long id) {
		super();
		this.id = id;
	}

	public BaseVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
