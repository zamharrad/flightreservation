package com.rad.flightreservation.security.config;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configurable
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity httpSecurity) {
        try {
            httpSecurity.authorizeRequests().antMatchers("/showReg", "/", "index.html", "/registerUser", "/login", "/showLogin","/findFlights", "/login/*")
                    .permitAll().antMatchers("/admin/showAddFlight").hasAnyAuthority("admin")
                    .anyRequest().authenticated().and().csrf().disable();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
