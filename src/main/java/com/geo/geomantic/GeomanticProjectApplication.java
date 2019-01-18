package com.geo.geomantic;

import com.geo.geomantic.common.config.CustomDialect;
import com.geo.geomantic.common.config.WorkFocusDialect;
import com.geo.geomantic.common.file.service.StorageService;
import com.geo.geomantic.common.constant.StorageProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 扫码mybatis 对应的到文件路径
 * MapperScan("com.geo.geomantic.module.dao")
 * springboot启动注解
 * SpringBootApplication
 * 扫描这些包下可以使用注入
 * ComponentScan(value = "com.geo.geomantic",lazyInit = true)
 * 识别包下的过滤器，拦截器，配置等等
 * ServletComponentScan("com.geo.geomantic")
 * 开启事物管理，在相应的类上加事物注解即可
 * EnableTransactionManagement
 * spring文件上传配置注入
 * EnableConfigurationProperties(StorageProperties.class)
 * @author zyz
 */
@MapperScan("com.geo.geomantic.module.dao")
@SpringBootApplication
@ComponentScan(value = "com.geo.geomantic",lazyInit = true)
@ServletComponentScan("com.geo.geomantic")
@EnableTransactionManagement
@EnableConfigurationProperties(StorageProperties.class)
public class GeomanticProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeomanticProjectApplication.class, args);
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n======================================================================\r\n");
		sb.append("\r\n    欢迎使用  风水网站  - Powered By ylz\r\n");
		sb.append("\r\n======================================================================\r\n");
		System.out.println(sb.toString());
	}

	/*
	 * 创建文件上传基础目录
	 */
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> storageService.init();
	}

	/**
	 * thymeleaf自定义语法
	 * @return
	 */
	@Bean
	public CustomDialect getDialect() {
		return new CustomDialect();
	}

	/**
	 * thymeleaf自定义使用对象
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	public WorkFocusDialect wlfDialect() {
		return new WorkFocusDialect();
	}
}

