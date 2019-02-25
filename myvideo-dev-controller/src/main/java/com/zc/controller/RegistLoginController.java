package com.zc.controller;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zc.domain.dto.UsersDTO;
import com.zc.domain.util.ResultUtil;
import com.zc.domain.vo.ResultVO;
import com.zc.domain.vo.UsersVO;
import com.zc.service.UsersService;

/**
 * @Description: 登录和注册
 * @author: zhangcheng
 * @date: 2019年1月12日
 */
@RestController
public class RegistLoginController {

	@Autowired
	private UsersService usersService;

	/**
	 * @Description: 注册
	 * @param usersVO
	 * @return
	 */
	@PostMapping("/regist")
	public ResultVO regist(@RequestBody UsersVO usersVO) {
		// 判断用户是否为空
		if (usersVO.getUsername() == null || usersVO.getPassword() == null) {
			return ResultUtil.errorMsg("用户名或密码不能为空");
		}
		UsersDTO usersDTO = new UsersDTO();
		usersDTO.setUsername(usersVO.getUsername());
		// 判断用户是否存在
		boolean isExist = usersService.isExistUsers(usersDTO);
		if (isExist) {
			return ResultUtil.errorMsg("用户名已存在");
		} else {
			usersVO.setNickname(usersVO.getUsername());
			usersVO.setFansCounts(0l);
			usersVO.setFollowCounts(0l);
			usersVO.setReceiveLikeCounts(0l);
			usersDTO.setFaceImage(null);
			usersDTO.setFansCounts(0l);
			usersDTO.setFollowCounts(0l);
			usersDTO.setNickname(usersVO.getNickname());
			usersDTO.setPassword(usersVO.getPassword());
			usersDTO.setReceiveLikeCounts(0l);
			usersService.regist(usersDTO);
			usersVO.setPassword(null);
			return ResultUtil.ok(usersVO);
		}

	}

	@PostMapping("/login")
	public ResultVO login(@RequestBody UsersVO usersVO) {
		if (usersVO.getUsername() == null || usersVO.getPassword() == null) {
			return ResultUtil.errorMsg("用户名或密码不能为空");
		}
		UsersDTO usersDTO = new UsersDTO();
		usersDTO.setUsername(usersVO.getUsername());
		usersDTO.setPassword(usersVO.getPassword());
		UsersDTO users = usersService.queryUsersForLogin(usersDTO);
		if (users == null) {
			return ResultUtil.errorMsg("用户或密码错误");
		}
		UsersVO usersVO2 = new UsersVO();
		usersVO2.setFaceImage(users.getFaceImage());
		usersVO2.setFansCounts(users.getFansCounts());
		usersVO2.setFollowCounts(users.getFollowCounts());
		usersVO2.setId(users.getId());
		usersVO2.setNickname(users.getNickname());
		usersVO2.setReceiveLikeCounts(users.getReceiveLikeCounts());
		usersVO2.setUsername(users.getUsername());
		String token = UUID.randomUUID().toString();
		usersService.AddUserSession(usersVO2.getId().toString(), token);
		usersVO2.setToken(token);
		return ResultUtil.ok(usersVO2);
	}

	@PostMapping("logout")
	public ResultVO logout(String userId) {
		usersService.removeUserSession(userId);
		return ResultUtil.ok();

	}

}
