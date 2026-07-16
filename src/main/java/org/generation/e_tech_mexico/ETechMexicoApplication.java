package org.generation.e_tech_mexico;

import org.generation.e_tech_mexico.configuracion.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ETechMexicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ETechMexicoApplication.class, args);
	}

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter(){
        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/api/productos/*");
        registrationBean.addUrlPatterns("/api/usuarios/*");

        return registrationBean;
    }
}
