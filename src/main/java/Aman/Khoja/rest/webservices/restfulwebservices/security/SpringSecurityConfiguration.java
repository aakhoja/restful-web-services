package Aman.Khoja.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        //requests should be authenticated
        httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        //add pop up for user login
        httpSecurity.httpBasic(withDefaults());

        //disable csrf token to enable PUT and POST
        httpSecurity.csrf().disable();
        return httpSecurity.build();
    }
}
