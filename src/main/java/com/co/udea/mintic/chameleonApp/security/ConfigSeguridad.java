package com.co.udea.mintic.chameleonApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class ConfigSeguridad extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    CustomSuccesHandler customSuccessHandler;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select correo,password,estado from empleado where correo=?")
                .authoritiesByUsernameQuery("select correo, rol_empleado from empleado where correo=?");
    }

    String[] resources = new String[]{"/css/**", "/img/**", "/js/**"};


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(resources).permitAll()
                .antMatchers(HttpMethod.POST).permitAll()
                .antMatchers("/RegistrarEmpleado").permitAll()
                .antMatchers("/VerEmpleados").access("hasRole('ADMIN')")
                .antMatchers("/VerEmpresas").access("hasRole('ADMIN')")
                .antMatchers("/VerMovimientos").access("hasRole('OPERARIO') or hasRole('ADMIN')")

////                .antMatchers(HttpMethod.OPTIONS).permitAll()
//                .antMatchers(HttpMethod.GET).permitAll()

////                .antMatchers(HttpMethod.PUT).permitAll()
////                .antMatchers(HttpMethod.DELETE).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
//                .defaultSuccessUrl("/index")
                .failureUrl("/login?error=true")
                .and().exceptionHandling().accessDeniedPage("/AccesoDenegado")
                .and()
                .logout()
                .permitAll()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout");
    }

//            http.authorizeRequests().antMatchers("/RegistrarEmpleado")
//                .permitAll()
//////                .antMatchers(HttpMethod.OPTIONS).permitAll()
////                .antMatchers(HttpMethod.GET).permitAll()
////                .antMatchers(HttpMethod.POST).permitAll()
//////                .antMatchers(HttpMethod.PUT).permitAll()
//////                .antMatchers(HttpMethod.DELETE).permitAll()
////                .anyRequest().authenticated()
//                .and()
//                .formLogin().successHandler(customSuccessHandler)
//                .loginPage("/login")
////                .permitAll()
//                .and()
//                .logout()
////                .invalidateHttpSession(true)
////                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//            .logoutSuccessUrl("/login?logout")
//                .permitAll();


}

