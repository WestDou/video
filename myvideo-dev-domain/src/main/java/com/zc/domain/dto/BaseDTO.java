package com.zc.domain.dto;

import java.io.Serializable;

/** 
 * @Description: 
 * @author: zhangcheng
 * @date: 2019年1月12日 
 */
public class BaseDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BaseDTO(Long id) {
		super();
		this.id = id;
	}

	public BaseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
