package com.zc.service;
/** 
 * @Description: 用户服务
 * @author: zhangcheng
 * @date: 2019年1月12日 
 */

import com.zc.domain.dto.UsersDTO;

public interface UsersService {

	/**
	 * @Description: 判断用户是否存在
	 * @param usersDTO
	 * @return
	 */
	public boolean isExistUsers(UsersDTO usersDTO);

	/**
	 * @Description: 注册用户
	 * @param usersDTO
	 * @return
	 */
	public void regist(UsersDTO usersDTO);

	/**
	 * @Description: 用户登录
	 * @param usersDTO
	 * @return
	 */
	public UsersDTO queryUsersForLogin(UsersDTO usersDTO);

	/**
	 * @Description: 添加session到redis
	 * @param userId
	 * @param token
	 */
	public void AddUserSession(String userId, String token);

	/**
	 * @Description: 更新用户信息
	 * @param userDTO
	 */
	public void updateUser(UsersDTO userDTO);

	/**
	 * @Description: 移除用户session
	 * @param userId
	 */
	public void removeUserSession(String userId);

}
