package com.hackerrank.gevents.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.hackerrank.gevents"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Event Application REST API Spring Boot v2.2.1.RELEASE",
				"An Application to manage events",
				"v1",
				"Terms Of Service",
				new Contact("Felipe Reis", "https://www.linkedin.com/in/felipereiss/", "felipereiss@outlook.com"),
				"License of API", "License of URL", Collections.emptyList());
	}
}
