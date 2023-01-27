package com.loja.online.api.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Configuration
public class Configuracao {
    
    @Bean
    public RestTemplate restTemplate() {
        var requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        return new RestTemplate(requestFactory);
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder().create();
    }
}
