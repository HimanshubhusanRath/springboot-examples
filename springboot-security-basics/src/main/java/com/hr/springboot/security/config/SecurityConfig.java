package com.hr.springboot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    @Primary
    public UserDetailsService userService() {
        UserDetails user = User.withDefaultPasswordEncoder() // For simplicity only, not recommended for production
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build();

        UserDetails supportUser = User.withDefaultPasswordEncoder()
                .username("support")
                .password("password")
                .roles("SUPPORT")
                .build();

        return new InMemoryUserDetailsManager(user, admin, supportUser);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable()
                .authorizeRequests(
                        authRequests ->
                                authRequests
                                        .antMatchers("/secure/admin/**").hasRole("ADMIN")
                                        .antMatchers("/secure/**").authenticated()

                )
                // Supports both Form login (Browser) and Basic Auth (From Postman)
                .formLogin()
                .and().httpBasic()
                .and().build();
    }
}
