package com.portfolio.hermosilla.Model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UsuarioAdmin implements UserDetails{
    
    private String user;
    private String name;
    private String password;
    private Boolean habilitado;    
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioAdmin(String user, String name, String password, Boolean habilitado) {
        this.user = user;
        this.name = name;
        this.password = password;
        this.habilitado = habilitado;
    }    
    
    public UsuarioAdmin(String user, String name, String password, Boolean habilitado, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.name = name;
        this.password = password;
        this.habilitado = habilitado;
        this.authorities = authorities;
    }
    
    public static UsuarioAdmin build(Usuario usuario){
        List<GrantedAuthority> auth = usuario.getPerfiles().stream().map(perfil -> 
                new SimpleGrantedAuthority(perfil.getPerfilNombre().name())).collect(Collectors.toList());
        return new UsuarioAdmin(usuario.getUser(), usuario.getName(), usuario.getPassword(), usuario.getHabilitado(), auth);
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return user;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    
}
