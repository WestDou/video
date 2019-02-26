package com.zc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zc.domain.po.BgmDO;
import com.zc.domain.util.ResultUtil;
import com.zc.domain.vo.ResultVO;
import com.zc.service.BgmService;

/**
 * @Description: 用户类
 * @author: zhangcheng
 * @date: 2019年1月19日
 */
@RestController
@RequestMapping("/bgm")
public class BgmController {

	@Autowired
	private BgmService bgmService;

	@PostMapping("list")
	public ResultVO listAllBgm() {
		List<BgmDO> bgmList = bgmService.listAllBgm();
		if(bgmList==null) {
			return ResultUtil.errorMsg("未知错误");
		}
		return ResultUtil.ok(bgmList);
	}

}
