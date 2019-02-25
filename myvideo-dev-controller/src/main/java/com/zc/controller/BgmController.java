package com.zc.controller;

import static org.mockito.Matchers.intThat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zc.domain.dto.UsersDTO;
import com.zc.domain.po.BgmDO;
import com.zc.domain.util.ResultUtil;
import com.zc.domain.vo.ResultVO;
import com.zc.service.BgmService;
import com.zc.service.UsersService;

/**
 * @Description: 用户类
 * @author: zhangcheng
 * @date: 2019年1月19日
 */
@RestController
@RequestMapping("/bgm")
public class BgmController {
	private static Logger log = LoggerFactory.getLogger(BgmController.class);

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
