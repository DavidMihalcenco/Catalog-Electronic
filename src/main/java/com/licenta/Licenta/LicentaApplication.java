package com.licenta.Licenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

@SpringBootApplication
public class LicentaApplication {

	public static void main(String[] args) {

		SpringApplication.run(LicentaApplication.class, args);
	}

	@Bean
	public FreeMarkerConfigurationFactoryBean getFreeMarkerConfig() {
		FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
		bean.setTemplateLoaderPath("classpath:/templates/");

		return bean;
	}

}


