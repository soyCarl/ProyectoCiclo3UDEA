package com.co.udea.mintic.chameleonApp.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomSuccesHandler  extends SimpleUrlAuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);
        if(response.isCommitted()){
            System.out.println("No se puede redireccionar");
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    public String determineTargetUrl(Authentication authentication){
        String url = "";
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<String>();

        for (GrantedAuthority a : authorities){
            roles.add(a.getAuthority());
            System.out.println("Custom"+roles.toString());
        }
        if(esAdmin(roles)){
            url="/VerEmpresas";
        }else if (esOperario(roles)){
            url = "/VerMovimientos";
        }else{
            url = "/AccesoDenegado";
        }
        return url;
    }

    private boolean esAdmin(List<String> roles){
        if(roles.contains("ADMIN")){
            return true;
        }
        return false;
    }

    private boolean esOperario(List<String> roles){
        if(roles.contains("OPERARIO")){
            return true;
        }
        return false;
    }
}
