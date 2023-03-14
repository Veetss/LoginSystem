package co.develhope.LoginSystemSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurity{

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/auth/**").permitAll()
                .antMatchers("/h2-console/**").permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

}
