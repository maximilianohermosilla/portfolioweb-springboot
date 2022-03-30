package com.portfolio.hermosilla.Service;

import com.portfolio.hermosilla.Model.Usuario;
import com.portfolio.hermosilla.Repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public List<Usuario> getUsuario() {
        List<Usuario> listaUsuarios = usuarioRepo.findAll();
        return listaUsuarios;
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        usuarioRepo.save(usuario);
        return usuario;
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepo.deleteById(id);
    }

    @Override
    public Usuario findUsuario(Long id) {
       Usuario usuarioTemp = usuarioRepo.findById(id).orElse(null);
       return usuarioTemp;
    }
    
}
