package com.endava.SmartDelivery.Config;

import com.endava.SmartDelivery.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().sameOrigin()
                .and()

                .authorizeRequests()
                .antMatchers("/register/**").anonymous()
                .antMatchers(HttpMethod.GET, "/country/",
                                                         "/address/",
                                                         "/customerAddress/",
                                                         "/customer/",
                                                         "/restaurant/",
                                                         "/menuItem/",
                                                         "/orderMenuItem/",
                                                         "/order/",
                                                         "/orderStatus/",
                                                         "/courier/").hasAnyRole("USER", "COURIER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/country/add",
                                                        "/address/add",
                                                        "/customerAddress/add",
                                                        "/customer/add",
                                                        "/restaurant/add",
                                                        "/menuItem/add",
                                                        "/orderMenuItem/add",
                                                        "/order/add",
                                                        "/orderStatus/add",
                                                        "/courier/add").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()

                .httpBasic()
                .and()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

}

