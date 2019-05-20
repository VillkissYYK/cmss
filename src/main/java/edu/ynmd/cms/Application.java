package edu.ynmd.cms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;
//import javax.servlet.annotation.MultipartConfig;

@SpringBootApplication
public class Application {
    public static  void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory f = new MultipartConfigFactory();
        f.setMaxFileSize("15MB");
        f.setMaxRequestSize("100MB");
        return  f.createMultipartConfig();
    }
}
