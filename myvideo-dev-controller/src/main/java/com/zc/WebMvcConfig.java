package com.zc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/** 
 * @Description: 资源映射配置文件
 * @author: zhangcheng
 * @date: 2019年1月20日 
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
				.addResourceLocations("file:D:/video_dev_img/")
				.addResourceLocations("file:D:/video_dev_audio/")
				.addResourceLocations("file:D:/video_dev_video/");
	}

	
}
