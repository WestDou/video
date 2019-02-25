package com.zc.domain.po;

import java.io.Serializable;

import javax.persistence.Id;

/** 
 * @Description: 
 * @author: zhangcheng
 * @date: 2019年1月12日 
 */
public class BaseDO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BaseDO(Long id) {
		super();
		this.id = id;
	}

	public BaseDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
