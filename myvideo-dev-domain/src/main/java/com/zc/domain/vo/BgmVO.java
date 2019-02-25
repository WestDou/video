package com.zc.domain.vo;

import javax.persistence.Table;

/** 
 * @Description: TODO
 * @author: zhangcheng
 * @date: 2019年2月11日 
 */
@Table(name = "video_bgm")
public class BgmVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	private String author;
	
	private String path;
	
	private String name;

	public String getAuthor() {
		return author;
	}

	public BgmVO() {
		super();
	}

	public BgmVO(Long id) {
		super(id);
	}

	public BgmVO(Long id, String author, String path, String name) {
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
