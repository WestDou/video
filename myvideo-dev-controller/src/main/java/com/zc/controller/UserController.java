package com.zc.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zc.domain.dto.UsersDTO;
import com.zc.domain.util.ResultUtil;
import com.zc.domain.vo.ResultVO;
import com.zc.service.UsersService;

/**
 * @Description: 用户类
 * @author: zhangcheng
 * @date: 2019年1月19日
 */
@RestController
@RequestMapping("/user")
public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UsersService usersService;

	@PostMapping("uploadFace")
	public ResultVO uploadFace(String userId, @RequestParam("file") MultipartFile[] files) {
		if (userId == null || files == null || files.length == 0) {
			return ResultUtil.errorMsg("文件上传错误");
		}
		String fileSpace = "D:/video_dev_img";
		String Relativepath = "/" + userId + "/" + UUID.randomUUID().toString() + ".png";
		String path = fileSpace + "/" + Relativepath;
		File Imgfile = new File(path);
		if (!Imgfile.getParentFile().exists()) {
			Imgfile.getParentFile().mkdirs();
		}
		InputStream is = null;
		OutputStream os = null;
		try {
			is = files[0].getInputStream();
			os = new FileOutputStream(new File(path));
			int length = -1;
			byte[] arr = new byte[100];
			while ((length = is.read(arr)) != -1) {
				os.write(arr, 0, length);
				os.flush();
			}
		} catch (IOException e) {
			log.error("{}", e);
			return ResultUtil.errorMsg("文件上传错误");
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					log.error("{}", e);
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					log.error("{}", e);
				}
			}
		}
		UsersDTO usersDTO = new UsersDTO();
		usersDTO.setId(Long.valueOf(userId));
		usersDTO.setFaceImage(Relativepath);
		usersService.updateUser(usersDTO);
		return ResultUtil.ok(usersDTO);
	}

}
