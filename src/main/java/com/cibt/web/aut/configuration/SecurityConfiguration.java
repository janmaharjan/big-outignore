/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.aut.configuration;

import com.cibt.web.aut.handler.LoginSucessHandler;
import com.cibt.web.aut.services.UserAuthService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Maharjan
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserAuthService userAuthService;
    
    @Autowired
    private LoginSucessHandler sucessHandler;
            
    SecurityConfiguration(){
        System.out.println("new khojya ho ?");
    }
   @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(). 
       //antMatchers("/").permitAll().
        anyRequest().authenticated().
        and().formLogin().loginPage("/login").
        usernameParameter("username").
        passwordParameter("password").
        successHandler(sucessHandler).
        permitAll().
        and().logout().permitAll().
        invalidateHttpSession(true);
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 
        
      /*     BCryptPasswordEncoder encoder=getPasswordEncoder(); 
       String userSql="select username,password,status from mst_users where username=?";
        System.out.println(userSql);
     String roleSql="select role_name,mst_users.username from mst_roles join mst_users on mst_users.role_id=mst_roles.id where mst_users.username=?";
     auth.jdbcAuthentication().
     passwordEncoder(encoder).usersByUsernameQuery(userSql).
     authoritiesByUsernameQuery(roleSql).
     dataSource(dataSource);
*/        
     
     /* 
   auth.inMemoryAuthentication().
     passwordEncoder(encoder).withUser("admin").
      password(encoder.encode("admin1234")).
                authorities("ADMIN");  
*/ 
     auth.authenticationProvider(getAuthProvider());
    }
    @Bean
    public DaoAuthenticationProvider getAuthProvider()
    {
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(getPasswordEncoder());
        provider.setUserDetailsService(userAuthService);
        return provider;
    }
    
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
} 

