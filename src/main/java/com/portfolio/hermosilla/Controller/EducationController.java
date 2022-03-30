package com.portfolio.hermosilla.Controller;

import org.springframework.http.HttpStatus;
import com.portfolio.hermosilla.Model.Education;
import com.portfolio.hermosilla.Service.IEducationService;
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
public class EducationController {
    
    @Autowired
    private IEducationService educationServ;
    
    @GetMapping ("education")
    public ResponseEntity<List<Education>> get(){
        List<Education> educations = educationServ.getEducation();
        return new ResponseEntity<List<Education>>(educations, HttpStatus.OK);
    }
    
    @PostMapping ("education/save")
    public ResponseEntity<Education> save(@RequestBody Education education) {
		Education educationTemp = educationServ.saveEducation(education);
		return new ResponseEntity<Education>(educationTemp, HttpStatus.OK);
    }
    
    @PutMapping ("education/{id}")
    public ResponseEntity<Education> edit(@PathVariable Long id,
                                     @RequestBody Education education){
        Education eduTemp = educationServ.findEducation(id);
        eduTemp.setCareer(education.getCareer());
        eduTemp.setSchool(education.getSchool());
        eduTemp.setImage(education.getImage());
        eduTemp.setScore(education.getScore());
        eduTemp.setStart(education.getStart());
        eduTemp.setEnd(education.getEnd());
        eduTemp.setTitle(education.getTitle());
        eduTemp.setPersona(education.getPersona());
        
        
        educationServ.saveEducation(eduTemp);
        return new ResponseEntity<Education>(eduTemp, HttpStatus.OK);        
    }
    
    @DeleteMapping ("education/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		educationServ.deleteEducation(id);
		return new ResponseEntity<String>("Education is deleted successfully.!", HttpStatus.OK);
    }
}