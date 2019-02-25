package com.zc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description: 启动类
 * @author: zhangcheng
 * @date: 2019年1月12日
 */
@SpringBootApplication
@MapperScan(basePackages="com.zc.mapper")
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
