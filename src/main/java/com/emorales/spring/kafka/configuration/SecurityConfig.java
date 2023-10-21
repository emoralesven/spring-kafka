package com.emorales.spring.kafka.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/actuator/**", "/kafka/info").permitAll() // Permitir todos los accesos a los endpoints del actuator y kafka/info
                .anyRequest().authenticated() // Para cualquier otra solicitud, autenticación es requerida
                .and()
                .httpBasic(); // Usar autenticación básica HTTP
    }
}

