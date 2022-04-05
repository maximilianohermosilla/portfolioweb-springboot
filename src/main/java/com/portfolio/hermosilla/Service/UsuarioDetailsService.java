package com.portfolio.hermosilla.Service;

import com.portfolio.hermosilla.Model.Usuario;
import com.portfolio.hermosilla.Model.UsuarioAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService{
    
    @Autowired
    UsuarioService usuarioService;
      
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByUser(username).get();
        return UsuarioAdmin.build(usuario);
    }
}
