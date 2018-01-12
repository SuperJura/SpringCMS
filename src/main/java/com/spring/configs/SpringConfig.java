/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author JuraLocal
 */
@Configuration
public class SpringConfig {
    
    @Bean
    public String test(){
        return "test";
    }
}
