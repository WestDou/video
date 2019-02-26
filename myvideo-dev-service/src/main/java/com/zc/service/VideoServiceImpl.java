package com.zc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.domain.dto.VideosDTO;
import com.zc.domain.po.VideosDO;
import com.zc.domain.util.PageVO;
import com.zc.domain.vo.VideosVO;
import com.zc.mapper.VideosMapper;
import com.zc.utils.ObjUtil;

/** 
 * @Description: TODO
 * @author: zhangcheng
 * @date: 2019年2月11日 
 */
@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private  VideosMapper videosMapper;
	@Override
	public void addVideo(VideosDTO video) {
		VideosDO videosDO = new VideosDO();
		ObjUtil.copy(video, videosDO);
		videosMapper.insertSelective(videosDO);
	}
	
	@Override
	public PageVO listAllVideo(String value,Integer pageNum,Integer pageSize) {
		//如果不为空，说明是查询操作，需要进行保存搜索关键词
		if(value != null) {
			
		}
		PageHelper.startPage(pageNum, pageSize);
		List<VideosVO> videos = videosMapper.listAllVideo(value);
		if(videos==null) {
			return null;
		}
		PageInfo<VideosVO> pageInfo = new PageInfo<>(videos);
		PageVO pageVO = new PageVO();
		pageVO.setList(videos);
		pageVO.setPageNum(pageNum);
		pageVO.setPages(pageInfo.getPages());
		pageVO.setTotal(pageInfo.getTotal());
		return pageVO;
	}

}
