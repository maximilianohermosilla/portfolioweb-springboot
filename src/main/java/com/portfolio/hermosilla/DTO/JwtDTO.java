package com.portfolio.hermosilla.DTO;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;


public class JwtDTO {
    
    private String token;
    private String bearer = "Bearer";
    private String user;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDTO(String token, String user, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.user = user;
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    
    
    
    
}
