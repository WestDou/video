package com.zc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.zc.constant.UserConstant;
import com.zc.domain.dto.UsersDTO;
import com.zc.domain.po.UsersDO;
import com.zc.mapper.UsersMapper;
import com.zc.utils.MD5Util;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @Description: 用户操作
 * @author: zhangcheng
 * @date: 2019年1月12日
 */
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Autowired
	private UsersMapper usersMapper;

	@Override
	public boolean isExistUsers(UsersDTO usersDTO) {
		UsersDO usersDO = new UsersDO();
		usersDO.setUsername(usersDTO.getUsername());
		UsersDO user = usersMapper.selectOne(usersDO);
		return user != null;
	}

	@Override
	public void regist(UsersDTO usersDTO) {
		UsersDO usersDO = new UsersDO();
		usersDO.setUsername(usersDTO.getUsername());
		usersDO.setPassword(MD5Util.toMD5(usersDTO.getPassword()));
		usersDO.setNickname(usersDTO.getNickname());
		usersDO.setFaceImage(null);
		usersDO.setFansCounts(0l);
		usersDO.setFollowCounts(0l);
		usersDO.setReceiveLikeCounts(0l);
		usersMapper.insert(usersDO);
	}

	@Override
	public UsersDTO queryUsersForLogin(UsersDTO usersDTO) {
		usersDTO.setPassword(MD5Util.toMD5(usersDTO.getPassword()));
		UsersDO usersDO = new UsersDO();
		usersDO.setUsername(usersDTO.getUsername());
		usersDO.setPassword(usersDTO.getPassword());
		UsersDO user = usersMapper.selectOne(usersDO);
		if (user != null) {
			UsersDTO usersDTO2 = new UsersDTO();
			usersDTO2.setFaceImage(user.getFaceImage());
			usersDTO2.setFansCounts(user.getFansCounts());
			usersDTO2.setFollowCounts(user.getFollowCounts());
			usersDTO2.setId(user.getId());
			usersDTO2.setNickname(user.getNickname());
			usersDTO2.setReceiveLikeCounts(user.getReceiveLikeCounts());
			usersDTO2.setUsername(user.getUsername());
			return usersDTO2;
		} else {
			return null;
		}

	}

	@Override
	public void AddUserSession(String userId, String token) {
		redisTemplate.opsForValue().set(UserConstant.USER_REDIS_SESSION + ":" + userId, token);

	}

	@Override
	public void updateUser(UsersDTO userDTO) {
		UsersDO usersDO = new UsersDO();
		usersDO.setFaceImage(userDTO.getFaceImage());
		usersDO.setFansCounts(userDTO.getFansCounts());
		usersDO.setFollowCounts(userDTO.getFollowCounts());
		usersDO.setId(userDTO.getId());
		usersDO.setNickname(userDTO.getNickname());
		if (userDTO.getPassword() != null) {
			usersDO.setPassword(MD5Util.toMD5(userDTO.getPassword()));
		}
		usersDO.setReceiveLikeCounts(userDTO.getReceiveLikeCounts());
		usersDO.setUsername(userDTO.getUsername());
		Example example = new Example(UsersDO.class);
		Criteria createCriteria = example.createCriteria();
		createCriteria.andEqualTo("id", usersDO.getId());
		usersMapper.updateByExampleSelective(usersDO, example);
	}

	@Override
	public void removeUserSession(String userId) {
		redisTemplate.delete(UserConstant.USER_REDIS_SESSION + ":" + userId);
	}

}
