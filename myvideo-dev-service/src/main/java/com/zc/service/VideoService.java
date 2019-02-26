package com.zc.service;


import com.zc.domain.dto.VideosDTO;
import com.zc.domain.util.PageVO;

/** 
 * @Description: TODO
 * @author: zhangcheng
 * @date: 2019年2月11日 
 */
public interface VideoService {
	public void addVideo(VideosDTO video);
	
	public PageVO listAllVideo(String value,Integer pageNum,Integer pageSize);
}
