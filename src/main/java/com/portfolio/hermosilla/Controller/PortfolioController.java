package com.portfolio.hermosilla.Controller;

import com.portfolio.hermosilla.DTO.PersonaDTO;
import com.portfolio.hermosilla.Model.Experience;
import com.portfolio.hermosilla.Model.Education;
import com.portfolio.hermosilla.Model.Persona;
import com.portfolio.hermosilla.Service.IEducationService;
import com.portfolio.hermosilla.Service.IExperienceService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
public class PortfolioController {
    
    @Autowired
    private IPersonaService personaServ;
    
    @Autowired
    private IExperienceService experienceServ;
    
    @Autowired
    private IEducationService educationServ;
    
    @GetMapping ("portfolioFull/{id}")
    public PersonaDTO getPersonas(@PathVariable Long id){        
        Persona persona = personaServ.findPersona(id);
        List<Experience> experienceList = experienceServ.getExperience();
        List<Education> educationList = educationServ.getEducation();
        Experience company;
        Education school;
        if(persona.getCompany()!=null){
            company = experienceServ.findExperience(persona.getCompany().getId());
        }
        else{
            company = new Experience();
        }
        if(persona.getSchool()!=null){
            school = educationServ.findEducation(persona.getSchool().getId());
        }  
        else{
            school = new Education();
        }
        PersonaDTO personaDTO = new PersonaDTO(persona.getId(),
                                            persona.getName(), 
                                            persona.getProfilePhoto(), 
                                            persona.getImage(), 
                                            persona.getPosition(), 
                                            persona.getUbication(), 
                                            persona.getAbout(), 
                                            company,
                                            school,
                                            experienceList, 
                                            educationList
                                            );
        
        return personaDTO;
        
    }
    
    @PutMapping ("portfolioEducation/{id}")
    public Persona editarEducation(@PathVariable Long id,
                                @RequestBody Education education){
        Persona personaFind = personaServ.findPersona(id); 
        personaFind.setSchool(education);      
        
        personaServ.savePersona(personaFind);
        return personaFind;
    }
    
    /*@PostMapping ("portfolio")
    public String createPersona(@RequestBody Persona persona){
        personaServ.savePersona(persona);
        return "Persona: " + persona.getName() + " creado correctamente";
    }*/
    
    /*@DeleteMapping ("portfolio/{id}")
    public String borrarPersona(@PathVariable Long id){
        //Persona persona = personaServ.findPersona(id);
        personaServ.deletePersona(id);
        return "Persona eliminada correctamente";
    }  */
    
}