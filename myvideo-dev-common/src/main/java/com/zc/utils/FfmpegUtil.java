package com.zc.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: ffmpeg工具类
 * @author: zhangcheng
 * @date: 2019年2月12日
 */
public class FfmpegUtil {
	private static final Logger log = LoggerFactory.getLogger(FfmpegUtil.class);
	private static final String ffmpegFile = "E:\\develop\\ffmpeg\\bin\\ffmpeg.exe";

	public static void mergeBgmAndVideo(String videoPath, String bgmPath, String duration, String newVideoPath) {
		List<String> commands = new ArrayList<>();
		commands.add(ffmpegFile);
		commands.add("-i");
		commands.add(videoPath);
		commands.add("-i");
		commands.add(bgmPath);
		commands.add("-t");
		commands.add(duration);
		commands.add("-y");
		commands.add(newVideoPath);
		ProcessBuilder processBuilder = new ProcessBuilder(commands);
		InputStream errorIs = null;
		BufferedReader errorBr = null;
		try {
			Process start = processBuilder.start();
			//错误流必须关闭，不然线程卡死
			errorIs = start.getErrorStream();
			Reader inputStreamReader2 = new InputStreamReader(errorIs);
			errorBr = new BufferedReader(inputStreamReader2);
			String errorS = null;
			while ((errorS = errorBr.readLine()) != null) {
			}
		} catch (IOException e) {
			log.error("{}", e);
		}finally {
			try {
				if (errorIs != null) {
					errorIs.close();
				}
				if (errorBr != null) {
					errorBr.close();
				}
			} catch (IOException e) {
				log.error("{}", e);
			}
		}
	}

	// ffmpeg.exe -ss 00:00:01 -y -i 1.avi -vframes 1 1.jpg
	public static void getVideoCover(String videoPath, String coverPath) {
		List<String> commands = new ArrayList<>();
		commands.add(ffmpegFile);
		commands.add("-ss");
		commands.add("00:00:01");
		commands.add("-y");
		commands.add("-i");
		commands.add(videoPath);
		commands.add("-vframes");
		commands.add("1");
		commands.add(coverPath);
		ProcessBuilder processBuilder = new ProcessBuilder(commands);
		InputStream errorIs = null;
		BufferedReader errorBr = null;
		try {
			Process start = processBuilder.start();

			errorIs = start.getErrorStream();
			Reader inputStreamReader2 = new InputStreamReader(errorIs);
			errorBr = new BufferedReader(inputStreamReader2);
			String errorS = null;
			while ((errorS = errorBr.readLine()) != null) {
			}
		} catch (IOException e) {
			log.error("{}", e);
		} finally {
			try {
				if (errorIs != null) {
					errorIs.close();
				}
				if (errorBr != null) {
					errorBr.close();
				}
			} catch (IOException e) {
				log.error("{}", e);
			}
		}
	}

	// public static void main(String[] args) {
	// FfmpegUtil.mergeBgmAndVideo("E:\\develop\\ffmpeg\\bin\\1.mp4",
	// "E:\\develop\\ffmpeg\\bin\\bgm.mp3", "6",
	// "E:\\develop\\ffmpeg\\bin\\新的文件.mp4");
	// FfmpegUtil.getVideoCover("E:\\develop\\ffmpeg\\bin\\1.avi",
	// "E:\\develop\\ffmpeg\\bin\\2.jpg");
	// }

}
