//package com.github.java4wro.user.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class UserSecurityAdapter extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().disable();
//
//        http.authorizeRequests()
//                .antMatchers("/login.html", "/hello.html").permitAll()
//                .antMatchers("/api/users/login").permitAll()
//                .antMatchers("/api/**").authenticated()
//                .anyRequest().authenticated();
//
//        http.formLogin()
//                .loginPage("/api/users/login")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .defaultSuccessUrl("hello.html")
//                .failureHandler((request, response, exception) -> response.sendError(HttpStatus.BAD_REQUEST.value(),
//                        "Your login or password is invalid"));
//
//        http.logout()
//                .logoutSuccessUrl("/login.html")
//                .deleteCookies("");
//
//    }
//
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        return null;
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
