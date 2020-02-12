package com.spring.git.bankApp.config;

import com.spring.git.bankApp.domain.user.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserFacade userFacade;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userFacade);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/v1/users").authenticated()
                .antMatchers("/v1/users/userpremium").hasRole("ADMIN")
                .antMatchers("/userstandard").hasAnyRole("ADMIN", "USER")
                .and().formLogin().permitAll()
                .and().csrf().disable();
    }
}
