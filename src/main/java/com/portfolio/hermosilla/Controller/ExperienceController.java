package com.portfolio.hermosilla.Controller;

import org.springframework.http.HttpStatus;
import com.portfolio.hermosilla.Model.Experience;
import com.portfolio.hermosilla.Service.IExperienceService;
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

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ExperienceController {
    
    @Autowired
    private IExperienceService experienceServ;
    
    @GetMapping ("experience")
    public ResponseEntity<List<Experience>> getExperience(){
        List<Experience> experiences = experienceServ.getExperience();
        return new ResponseEntity<List<Experience>>(experiences, HttpStatus.OK);
    }
    
    @PostMapping ("experience")
    public ResponseEntity<Experience> save(@RequestBody Experience experience) {
		Experience experienceTemp = experienceServ.saveExperience(experience);
		return new ResponseEntity<Experience>(experienceTemp, HttpStatus.OK);
	}
    
    /*public Experience createExperience(@RequestBody Experience experience){
        experienceServ.saveExperience(experience);
        //return "Experiencia creada correctamente";
        return experience;
    }*/
    
    @PutMapping ("experience/{id}")
    public ResponseEntity<Experience> editExperience(@PathVariable Long id,
                                     @RequestBody Experience experience){
        Experience expTemp = experienceServ.findExperience(id);
        expTemp.setCompany(experience.getCompany());
        expTemp.setPosition(experience.getPosition());
        expTemp.setImg(experience.getImg());
        expTemp.setMode(experience.getMode());
        expTemp.setStart(experience.getStart());
        expTemp.setEnd(experience.getEnd());
        expTemp.setTimeElapsed(experience.getTimeElapsed());
        expTemp.setUbication(experience.getUbication());
        
        experienceServ.saveExperience(expTemp);
        return new ResponseEntity<Experience>(expTemp, HttpStatus.OK);        
    }
    
    @DeleteMapping ("experience/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        experienceServ.deleteExperience(id);
        return new ResponseEntity<String>("Experience is deleted successfully.!", HttpStatus.OK);
    }
    /*public void deleteExperience(@PathVariable Long id){
        experienceServ.deleteExperience(id);
        //return "Experiencia eliminada correctamente";
    }*/
    
    
    
    
    
    








    
}
