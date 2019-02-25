package com.zc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zc.constant.VideoConstant;
import com.zc.domain.dto.BgmDTO;
import com.zc.domain.dto.VideosDTO;
import com.zc.domain.util.PageVO;
import com.zc.domain.util.ResultUtil;
import com.zc.domain.vo.ResultVO;
import com.zc.en.Video;
import com.zc.service.BgmService;
import com.zc.service.VideoService;
import com.zc.utils.FfmpegUtil;

/**
 * @Description: TODO
 * @author: zhangcheng
 * @date: 2019年2月11日
 */
@RestController
@RequestMapping("video")
public class VideoController {
	private final static Logger log = LoggerFactory.getLogger(VideoController.class);

	@Autowired
	private VideoService videoService;

	@Autowired
	private BgmService bgmService;

	@PostMapping("uploadVideo")
	public ResultVO uploadVideo(Integer userId, Integer bgmId, Integer height, Integer width, String desc,
			Double duration, MultipartFile file) {
		if (file == null || userId == null || height == null || width == null || duration == null) {
			ResultUtil.errorMsg("上传错误");
		}
		String fileSpace = "D:/video_dev_video";
		String Relativepath = "/" + userId + "/" + UUID.randomUUID().toString() + ".mp4";//注意这里最好是MP4格式，其他格式访问就直接下载了
		String path = fileSpace + "/" + Relativepath;
		File videoFile = new File(path);
		if (!videoFile.getParentFile().exists()) {
			videoFile.getParentFile().mkdirs();
		}
		InputStream is = null;
		OutputStream os = null;
		try {
			is = file.getInputStream();
			os = new FileOutputStream(videoFile);
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
		//截取到封面
		String coverRelativepath = "/" + userId + "/" + UUID.randomUUID().toString() + ".jpg";
		FfmpegUtil.getVideoCover(path, fileSpace+coverRelativepath);
		if (bgmId != null) {
			// 进行bgm和视频的合并
			BgmDTO bgmDTO = bgmService.queryBgmByBgmId(bgmId);
			String bgmPath = bgmDTO.getPath();
			String bgmfloder = "D:\\video_dev_audio";
			String finalBgmPath = bgmfloder + bgmPath;
			Relativepath = "/" + userId + "/" + UUID.randomUUID().toString() + ".mp4";
			String newVideoPath = fileSpace + "/" + Relativepath;
			FfmpegUtil.mergeBgmAndVideo(path, finalBgmPath, duration+"", newVideoPath);
		}
		VideosDTO videosDTO = new VideosDTO();
		videosDTO.setUserId(userId);
		videosDTO.setAudioId(bgmId);
		videosDTO.setLikeCounts(0l);
		videosDTO.setVideoDesc(desc);
		videosDTO.setVideoHeight(height);
		videosDTO.setVideoPath(Relativepath);
		videosDTO.setVideoSeconds(duration);
		videosDTO.setVideoWidth(width);
		videosDTO.setCoverPath(coverRelativepath);
		videosDTO.setCreateTime(new Date().getTime());
		videosDTO.setStatus(Video.Available.getValue());
		videoService.addVideo(videosDTO);
		return ResultUtil.ok();

	}
	
	@PostMapping("/listAllVideo")
	public ResultVO listAllVideo(String value,Integer pageNum) {
		
		if(pageNum==null) {
			pageNum = 1;
		}
		PageVO videos = videoService.listAllVideo(value,pageNum, VideoConstant.pageSize);
		if(videos==null) {
			return ResultUtil.errorMsg("查询出错");
		}
		return ResultUtil.ok(videos);
	}

}
