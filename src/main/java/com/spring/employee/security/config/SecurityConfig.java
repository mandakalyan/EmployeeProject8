package com.spring.employee.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//import com.spring.employee.security.service.CustomUserDetailsService;

import jakarta.activation.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

//    @Autowired
//    private CustomUserDetailsService userDetailsService;
//    

    
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//    	provider.setUserDetailsService(userDetailsService);
//        return provider;
//    	
//    }
//    
   

  

//    @Bean
//    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception  {
//        return  configuration.getAuthenticationManager();
//    }
//


  
    @Bean
    public SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
    	  
        http.authorizeHttpRequests()
                .requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();
        
        return  http.build();
    }
    @Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager(){

		UserDetails admin = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
			.username("admin")
			.password("1234")
			.roles("ADMIN")
			.build();
			
		return new InMemoryUserDetailsManager(admin);
	}

   
   
}
