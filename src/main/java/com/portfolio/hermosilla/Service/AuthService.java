package com.portfolio.hermosilla.Service;

import com.portfolio.hermosilla.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
     @Autowired
     private UsuarioRepository usuarioRepo;
     
     
}
