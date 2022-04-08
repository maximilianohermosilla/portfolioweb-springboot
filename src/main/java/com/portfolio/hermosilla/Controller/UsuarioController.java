package com.portfolio.hermosilla.Controller;

import org.springframework.http.HttpStatus;
import com.portfolio.hermosilla.Model.Usuario;
import com.portfolio.hermosilla.Service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioServ;
    
    @GetMapping ("usuario")
    public ResponseEntity<List<Usuario>> get(){
        List<Usuario> usuarios = usuarioServ.getUsuario();
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }
    
    @PostMapping ("usuario/save")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        Usuario usuarioTemp = usuarioServ.saveUsuario(usuario);
        return new ResponseEntity<Usuario>(usuarioTemp, HttpStatus.OK);
    }
    
    @PutMapping ("usuario/{id}")
    public ResponseEntity<Usuario> edit(@PathVariable Long id,
                                     @RequestBody Usuario usuario){
        Usuario usuarioTemp = usuarioServ.findUsuario(id);
        usuarioTemp.setHabilitado(usuario.getHabilitado());
        usuarioTemp.setUser(usuario.getUser());
        usuarioTemp.setPassword(usuario.getPassword());
        usuarioTemp.setPersona(usuario.getPersona());        
        
        usuarioServ.saveUsuario(usuarioTemp);
        return new ResponseEntity<Usuario>(usuarioTemp, HttpStatus.OK);        
    }
    
    @DeleteMapping ("usuario/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        usuarioServ.deleteUsuario(id);
        return new ResponseEntity<String>("Usuario is deleted successfully.!", HttpStatus.OK);
    }
}