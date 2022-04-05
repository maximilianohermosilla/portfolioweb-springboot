package com.portfolio.hermosilla.DTO;

import com.sun.istack.NotNull;


public class LoginUsuarioDTO {
    
    @NotNull
    private String user;
  
    @NotNull
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginUsuarioDTO(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
    
}
