package com.geo.geomantic;

import com.geo.geomantic.common.config.CustomDialect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zyz
 */
@MapperScan("com.geo.geomantic.module.dao")
@SpringBootApplication
@ComponentScan(value = "com.geo.geomantic",lazyInit = true)
@ServletComponentScan("com.geo.geomantic")
public class GeomanticProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeomanticProjectApplication.class, args);
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n======================================================================\r\n");
		sb.append("\r\n    欢迎使用  风水网站  - Powered By ylz\r\n");
		sb.append("\r\n======================================================================\r\n");
		System.out.println(sb.toString());
	}

	@Bean
	public CustomDialect getDialect() {
		return new CustomDialect();
	}

}

