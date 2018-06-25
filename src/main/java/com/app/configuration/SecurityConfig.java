package com.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.app.service.UserService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private UserService userService;
	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//              //  .antMatchers("/predavanja/**").permitAll()
//                .antMatchers("/predavanja/new-lecture").hasAnyRole("ADMIN","PROFESSOR")
//                .antMatchers("/predavanja/predavanja-popis").hasAnyRole("ADMIN","PROFESSOR")
//                //.antMatchers("/predavanja**").hasAuthority("ROLE_ADMI")
//                    .antMatchers(
//                            "/registration**",
//                            "/js/**",
//                            "/css/**",
//                            "/img/**",
//                            "/webjars/**").permitAll()
//                    .anyRequest().authenticated()
//                .and()
//                    .formLogin()
//                        .loginPage("/login")
//                            .permitAll()//.defaultSuccessUrl("/welcome")
//
//                .and()
//                    .logout()
//                        .invalidateHttpSession(true)
//                        .clearAuthentication(true)
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .logoutSuccessUrl("/login?logout")
//                .permitAll().and().exceptionHandling()
//                .accessDeniedPage("/forbidden");
//    }
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

}
