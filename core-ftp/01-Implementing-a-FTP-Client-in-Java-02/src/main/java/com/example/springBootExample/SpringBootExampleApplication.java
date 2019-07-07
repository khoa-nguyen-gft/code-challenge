package com.example.springBootExample;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
public class SpringBootExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}
	
	public static class ApplicationInit extends AbstractAnnotationConfigDispatcherServletInitializer {

		
		@Override
		protected Filter[] getServletFilters() {
			DelegatingFilterProxy filterProxy = new DelegatingFilterProxy();
			filterProxy.setTargetBeanName("applicationFilter");
			return new Filter[] {filterProxy};
		}
		
		@Override
		protected Class<?>[] getRootConfigClasses() {
			return null;
		}

		@Override
		protected Class<?>[] getServletConfigClasses() {
			return null;
		}

		@Override
		protected String[] getServletMappings() {
			return null;
		}
		
	}

}
