package com.portfolio.hermosilla.DTO;

import com.sun.istack.NotNull;
import java.util.HashSet;
import java.util.Set;


public class UsuarioDTO {
    @NotNull
    private String user;
    @NotNull
    private String name;
    @NotNull
    private String password;
    private boolean habilitado;
    private Set<String> perfiles = new HashSet<>();

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Set<String> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(Set<String> perfiles) {
        this.perfiles = perfiles;
    }
    
    
    
}
