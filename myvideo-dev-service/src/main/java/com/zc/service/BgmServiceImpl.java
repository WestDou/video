package com.zc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zc.domain.dto.BgmDTO;
import com.zc.domain.po.BgmDO;
import com.zc.mapper.BgmMapper;
import com.zc.utils.ObjUtil;

/** 
 * @Description: TODO
 * @author: zhangcheng
 * @date: 2019年2月10日 
 */
@Service
public class BgmServiceImpl implements BgmService {
	@Autowired
	private BgmMapper bgmMapper;

	@Override
	public List<BgmDO> listAllBgm() {
		List<BgmDO> bgmList = bgmMapper.selectAll();
		return bgmList;
	}

	@Override
	public BgmDTO queryBgmByBgmId(Integer bgmId) {
		BgmDO bgmDO = bgmMapper.selectByPrimaryKey(bgmId);
		BgmDTO bgmDTO = new BgmDTO();
		ObjUtil.copy(bgmDO, bgmDTO);
		return bgmDTO;
	}

}
