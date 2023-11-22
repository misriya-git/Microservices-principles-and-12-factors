package com.online.reviewservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.online.reviewservice.exception.BadRequestException;
import com.online.reviewservice.exception.InternalServerErrorException;
import com.online.reviewservice.exception.ReviewNotFoundException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Configuration
public class CustomErrorDecoder implements ErrorDecoder {


    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 400:
                return new BadRequestException("Bad Request!");
            case 404:
                return new ReviewNotFoundException("Review Not Found!");
            case 500:
                return new InternalServerErrorException("Internal Server Error!");
            default:
                return new Exception("Generic exception");
        }
    }
    
    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
    
}
