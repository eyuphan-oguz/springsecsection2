package com.eazybytes.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
            authorize->authorize
            .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
            .requestMatchers("/notices","/contact").permitAll());
            http.formLogin();
            http.httpBasic();

        
        return http.build();
    }

}
// http.authorizeHttpRequests(authorize->authorize.anyRequest().authenticated())
        // .formLogin(formLogin ->
        //         formLogin
        //             .loginPage("/login")
        //             .permitAll()
        //     );
        // http.httpBasic();