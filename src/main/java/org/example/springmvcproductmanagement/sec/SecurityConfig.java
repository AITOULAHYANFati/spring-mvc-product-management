package org.example.springmvcproductmanagement.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("user1").password(passwordEncoder().encode("123")).roles("USER").build(),
                User.withUsername("user2").password(passwordEncoder().encode("123")).roles("USER").build(),
                User.withUsername("admin").password(passwordEncoder().encode("123")).roles("USER","ADMIN").build()
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //                         ^^^^^^^^^^^^^^^^^^^ nom changé ici
        http
                .formLogin(form -> form
                        .defaultSuccessUrl("/index")
                        .permitAll()
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/webjars/**", "/h2-console/**").permitAll()
                        .requestMatchers("/index/**").hasRole("USER")
                        .requestMatchers("/save/**", "/delete/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}