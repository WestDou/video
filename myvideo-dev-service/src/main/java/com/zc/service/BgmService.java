package com.zc.service;
/** 
 * @Description: TODO
 * @author: zhangcheng
 * @date: 2019年2月10日 
 */

import java.util.List;

import com.zc.domain.dto.BgmDTO;
import com.zc.domain.po.BgmDO;


public interface BgmService {
	public List<BgmDO> listAllBgm();
	
	public BgmDTO queryBgmByBgmId(Integer bgmId);
}
