package com._6bitcampers.nangman_doctor.config;

import com._6bitcampers.nangman_doctor.servingPackage.jangwoo.loginService.customOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class securityConfig {

    private final customOAuth2UserService customOAuth2UserService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //csrf 설정 해제(POST 전송 시 CSRF 토큰값을 요구하지만 해당 설정으로 잠깐 꺼둘수 있음)
        http
                .csrf((auth) -> auth.disable());

        http
                .formLogin((login) -> login.disable());

        http
                .httpBasic((basic) -> basic.disable());

        http
                .oauth2Login((oauth) -> oauth
                        .userInfoEndpoint((userInfoEndpointConfig)-> userInfoEndpointConfig
                                .userService(customOAuth2UserService)));
        //경로에 대한 권한
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/my/**").authenticated()
                        .anyRequest().permitAll());

        return http.build();
    }
}
