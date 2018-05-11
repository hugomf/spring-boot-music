package org.ocelot.musiclibrary;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
	
	private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot REST API",
                "Spring Boot REST API for Online Store",
                "1.0",
                "Terms of service",
                new Contact("John Thompson", "https://springframework.guru/about/", "john@springfrmework.guru"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", null);
        return apiInfo;
    }
	
	
//	 @Bean
//	  public WebMvcConfigurerAdapter adapter() {
//	    return new WebMvcConfigurerAdapter() {
//	      @Override
//	      public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	        registry.addResourceHandler("swagger-ui.html")
//	            .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
//	        registry.addResourceHandler("/webjars/**")
//	            .addResourceLocations("classpath:/META-INF/resources/webjars/");
//
//	        super.addResourceHandlers(registry);
//	      }
//	    };
//	 }
	
}
