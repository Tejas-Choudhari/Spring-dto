package com.example.demo;

import org.springframework.boot.SpringApplication;
import com.example.demo.documentation.ApiKeyFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication 
public class SpringDtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDtoApplication.class, args);
	}
	 
	@Bean
    public FilterRegistrationBean<ApiKeyFilter> apiKeyFilter() {
        FilterRegistrationBean<ApiKeyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ApiKeyFilter());
        registrationBean.addUrlPatterns("/user/save/v2","/user/findAll","/user/find/v2/3","/user/find/v2/4","/user/find/v2/5","/user/find/v2/6"); 
        return registrationBean; 
    }

}
