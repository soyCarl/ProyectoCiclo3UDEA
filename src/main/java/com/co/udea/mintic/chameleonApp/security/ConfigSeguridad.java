package com.co.udea.mintic.chameleonApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class ConfigSeguridad extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    CustomSuccesHandler customSuccessHandler;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select correo,password,estado from empleado where correo=?")
                .authoritiesByUsernameQuery("select correo, rol_empleado from empleado where correo=?");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","VerEmpresas/**").hasRole("ADMIN")
                .antMatchers("/VerEmpleados/**").hasRole("ADMIN")
                .antMatchers("/Empresa/**").hasRole("ADMIN")
                .antMatchers("/Empleado/**").hasRole("ADMIN")
                .antMatchers("/VerMovimiento/**").hasAnyRole("ADMIN","OPERARIO")
                .antMatchers("/AgregarMovimiento/**").hasAnyRole("ADMIN","OPERARIO")
                .antMatchers("/EditarMovimiento/**").hasAnyRole("ADMIN","OPERARIO")
                .and().formLogin().successHandler(customSuccessHandler)
                .and().exceptionHandling().accessDeniedPage("/AccessDenied")
                .and().logout().permitAll();
    }
}

