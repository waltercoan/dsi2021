package br.univille.walterdsi2021.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.univille.walterdsi2021.service.impl.MyUserDetailsServiceImpl;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
        .authorizeRequests()
        .antMatchers("/fonte_dados/**").permitAll()
        .anyRequest().authenticated().and().formLogin();

        httpSecurity.csrf().ignoringAntMatchers("/fonte_dados/**");
        httpSecurity.headers().frameOptions().sameOrigin();
    }
    @Autowired
    private MyUserDetailsServiceImpl myUserDetailService;

    protected void cofigure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    

}
