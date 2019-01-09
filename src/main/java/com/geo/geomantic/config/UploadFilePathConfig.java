package com.geo.geomantic.config;

import com.geo.geomantic.common.config.Global;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author zyz
 * @date 2019/1/9
 */
@Configuration
public class UploadFilePathConfig extends WebMvcConfigurationSupport {

    @Value("${userfiles.basedir}")
    private String uploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/userfiles/**").addResourceLocations("file:" + uploadFolder + Global.USERFILES_BASE_URL);
    }
}
