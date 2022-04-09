package com.portfolio.hermosilla.Controller;

import com.portfolio.hermosilla.DTO.JwtDTO;
import com.portfolio.hermosilla.DTO.LoginUsuarioDTO;
import com.portfolio.hermosilla.DTO.Mensaje;
import com.portfolio.hermosilla.DTO.UsuarioDTO;
import com.portfolio.hermosilla.Model.Perfil;
import com.portfolio.hermosilla.Model.Persona;
import com.portfolio.hermosilla.Model.Usuario;
import com.portfolio.hermosilla.Service.AuthService;
import com.portfolio.hermosilla.Service.PerfilService;
import com.portfolio.hermosilla.Service.PersonaService;
import com.portfolio.hermosilla.Service.UsuarioService;
import com.portfolio.hermosilla.enums.PerfilNombre;
import com.portfolio.hermosilla.jwt.JwtProvider;
import com.portfolio.hermosilla.jwt.JwtTokenFilter;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    
     private final static Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    @Autowired
    private AuthService authService;
    
    @Autowired
    private PersonaService personaService;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    PerfilService perfilService;
    
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody UsuarioDTO nuevoUsuario, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existeByUser(nuevoUsuario.getUser())){
            return new ResponseEntity(new Mensaje("El usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(nuevoUsuario.getName());
        personaService.savePersona(persona);
        Usuario usuario = new Usuario(nuevoUsuario.getUser(), nuevoUsuario.getName(), passwordEncoder.encode(nuevoUsuario.getPassword()),true, persona);
        Set<Perfil> perfiles = new HashSet<>();
        perfiles.add(perfilService.getByPerfilNombre(PerfilNombre.PERFIL_USER).get());
        if(nuevoUsuario.getPerfiles().contains("admin")){
            perfiles.add(perfilService.getByPerfilNombre(PerfilNombre.PERFIL_ADMIN).get());
        }
        usuario.setPerfiles(perfiles);
        
        //usuarioService.saveUsuario(usuario);
        return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
            
        } catch (Exception e) {
             logger.error("fail en el metodo doFilter");
             return new ResponseEntity(new Mensaje(e.toString()), HttpStatus.BAD_REQUEST);
        }
        //return new ResponseEntity(new Mensaje("El usuario ya existe"), HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuarioDTO loginUsuario, BindingResult bindingResult){
        //try {
            if (bindingResult.hasErrors()){
                return new ResponseEntity(new Mensaje("Usuario o contraseña incorrectos"), HttpStatus.BAD_REQUEST);
            }
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getUser(), loginUsuario.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
            return new ResponseEntity(jwtDTO, HttpStatus.OK);
            
        //} catch (Exception e) {
        //    logger.error("fail en el metodo doFilter");
        //    return new ResponseEntity(new Mensaje(e.toString()), HttpStatus.BAD_REQUEST);
        //}        
        
    }
}
