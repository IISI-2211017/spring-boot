package com.openapi.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
	  @Bean
	  public GroupedOpenApi publicApi() {
	      return GroupedOpenApi.builder()
	              .group("com")
	              .pathsToMatch("/jap/multiDB/**")
	              .build();
	  }
	  
	  @Bean
	  public GroupedOpenApi publicApi2() {
	      return GroupedOpenApi.builder()
	              .group("com2")
	              .pathsToMatch("/jap/multiDB2/**")
	              .build();
	  }
	  
	  
	  
}
