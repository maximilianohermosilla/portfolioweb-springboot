package com.portfolio.hermosilla.Controller;

import com.portfolio.hermosilla.Model.Persona;
import com.portfolio.hermosilla.Service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
public class PersonaController {
    
    @Autowired
    private IPersonaService personaServ;
    
    @GetMapping ("portfolio")
    public List<Persona> getPersonas(){
        return personaServ.getPersona();
    }
    
    @PostMapping ("portfolio")
    public String createPersona(@RequestBody Persona persona){
        personaServ.savePersona(persona);
        return "Persona: " + persona.getName() + " creado correctamente";
    }
    
    @PutMapping ("portfolio/{id}")
    public Persona editarPersona(@PathVariable Long id,
                                @RequestBody Persona persona){
        Persona personaFind = personaServ.findPersona(id);
        personaFind.setName(persona.getName());
        personaFind.setProfilePhoto(persona.getProfilePhoto());
        personaFind.setImage(persona.getImage());
        personaFind.setPosition(persona.getPosition());
        personaFind.setUbication(persona.getUbication());
        personaFind.setAbout(persona.getAbout());        
        
        personaServ.savePersona(personaFind);
        return persona;
    }
    
    @DeleteMapping ("portfolio/{id}")
    public String borrarPersona(@PathVariable Long id){
        //Persona persona = personaServ.findPersona(id);
        personaServ.deletePersona(id);
        return "Persona eliminada correctamente";
    }  
    
}
