package com.loja.carros.infra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configuração permissiva para desenvolvimento
        registry.addMapping("/**") // Aplica a todas as rotas da API
                .allowedOrigins("*") // Permite acesso de qualquer origem (Web ou Mobile)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*"); // Headers permitidos
    }
}