package br.com.mundo_organico.Mundo_Organico.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.mundo_organico.Mundo_Organico.interceptors.AutorizeInterceptor;

@Configuration
public class Config implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AutorizeInterceptor());
    }
}
