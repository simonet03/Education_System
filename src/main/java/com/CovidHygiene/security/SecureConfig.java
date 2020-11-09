package com.CovidHygiene.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecureConfig extends WebSecurityConfigurerAdapter {

    public static final String User_Role = "User";
    public static final String Admin_Role = "Admin";
    public static final String Teacher_Role ="Teacher";

    //authenticate user roles here
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                //ADMIN
                .withUser("admin")
                .password(encoder().encode("123"))
                .roles(Admin_Role, User_Role, Teacher_Role)

                //add more than one user
        .and()

                .withUser("user")
                .password(encoder().encode("456"))
                .roles(User_Role)
         .and()

                .withUser("Teacher")
                .password(encoder().encode("Password9"))
                .roles(Teacher_Role);
    }

    //assign user rights here
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/educationsystem/**/create", "/educationsystem/**/update").hasAnyRole(Admin_Role)
                .antMatchers(HttpMethod.DELETE,  "/educationsystem/**/delete/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.GET, "/educationsystem/**/read/**", "/educationsystem/**/getAll/**", "/educationsystem/**/get/**","/educationsystem/**/getAllBookedClassrooms/**","/educationsystem/**/getAllNotBookedClassrooms/**","/educationsystem/**/getAllSanitizedClassrooms/**","/educationsystem/**/getAllNotSanitizedClassrooms/**").hasAnyRole(User_Role,Teacher_Role)
                .antMatchers(HttpMethod.POST,  "/educationsystem/**/update").hasAnyRole(Teacher_Role)
                .and()
                .csrf().disable(); /**disable cross referencing**/


    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();

    }
}
