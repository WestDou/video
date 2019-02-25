package com.zc.domain.po;

import javax.persistence.Table;

/** 
 * @Description: TODO
 * @author: zhangcheng
 * @date: 2019年2月11日 
 */
@Table(name = "video_bgm")
public class BgmDO extends BaseDO {

	private static final long serialVersionUID = 1L;
	
	private String author;
	
	private String path;
	
	private String name;

	public String getAuthor() {
		return author;
	}

	public BgmDO() {
		super();
	}

	public BgmDO(Long id) {
		super(id);
	}

	public BgmDO(Long id, String author, String path, String name) {
		super(id);
		this.author = author;
		this.path = path;
		this.name = name;
	}

	@Override
	public String toString() {
		return "BgmVO [author=" + author + ", path=" + path + ", name=" + name + "]";
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
