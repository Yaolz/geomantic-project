package com.geo.geomantic;

import com.geo.geomantic.common.config.CustomDialect;
import com.geo.geomantic.common.config.WorkFocusDialect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zyz
 */
@MapperScan("com.geo.geomantic.module.dao")
@SpringBootApplication
@ComponentScan(value = "com.geo.geomantic",lazyInit = true)
@ServletComponentScan("com.geo.geomantic")
@EnableTransactionManagement        // 开启事务管理支持
public class GeomanticProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeomanticProjectApplication.class, args);
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n======================================================================\r\n");
		sb.append("\r\n    欢迎使用  风水网站  - Powered By ylz\r\n");
		sb.append("\r\n======================================================================\r\n");
		System.out.println(sb.toString());
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

