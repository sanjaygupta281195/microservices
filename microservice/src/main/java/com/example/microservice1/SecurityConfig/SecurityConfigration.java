package com.example.microservice1.SecurityConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigration {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
//        httpSecurity.authorizeHttpRequests((request)->
//            request.requestMatchers("/person/getPerson").permitAll()
//                    .requestMatchers("/person/getPersonDetails").hasRole("ADMIN")
//                    .requestMatchers("/person/user").hasRole("USER")
//        ).httpBasic(Customizer.withDefaults());
//        return httpSecurity.build();
//    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeRequests()
                .anyRequest().permitAll()  // Allow all requests without authentication
                .and()
                .httpBasic().disable()          // Disable HTTP Basic Authentication
                .csrf().disable();              // Disable CSRF protection (optional for API use)

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("ADMIN")
                .password("ADMIN")
                .roles("ADMIN","USER").build();

        UserDetails user =  User.withDefaultPasswordEncoder()
                .username("USER")
                .password("USER")
                .roles("USER").build();

        return new InMemoryUserDetailsManager(admin,user);
    }
}
