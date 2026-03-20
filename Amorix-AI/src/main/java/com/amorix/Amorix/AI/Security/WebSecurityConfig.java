package com.amorix.Amorix.AI.Security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) {
        httpSecurity.csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessionManagementConfig -> sessionManagementConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/api/**").permitAll()
                );

            return httpSecurity.build();
    }
}
