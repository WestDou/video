package com.zc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zc.domain.po.VideosDO;
import com.zc.domain.vo.VideosVO;

import tk.mybatis.mapper.common.Mapper;

/** 
 * @Description: TODO
 * @author: zhangcheng
 * @date: 2019年2月11日 
 */
public interface VideosMapper extends Mapper<VideosDO>{
	
	public List<VideosVO> listAllVideo(@Param("desc") String desc);

}
