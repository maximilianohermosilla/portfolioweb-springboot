package com.portfolio.hermosilla.Controller;

import org.springframework.http.HttpStatus;
import com.portfolio.hermosilla.Model.Skill;
import com.portfolio.hermosilla.Service.ISkillService;
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
public class SkillController {
    
    @Autowired
    private ISkillService skillServ;
    
    @GetMapping ("skill")
    public ResponseEntity<List<Skill>> get(){
        List<Skill> skills = skillServ.getSkill();
        return new ResponseEntity<List<Skill>>(skills, HttpStatus.OK);
    }
    
    @PostMapping ("skill/save")
    public ResponseEntity<Skill> save(@RequestBody Skill skill) {
        Skill skillTemp = skillServ.saveSkill(skill);
        return new ResponseEntity<Skill>(skillTemp, HttpStatus.OK);
    }
    
    @PutMapping ("skill/{id}")
    public ResponseEntity<Skill> edit(@PathVariable Long id,
                                     @RequestBody Skill skill){
        Skill skillTemp = skillServ.findSkill(id);
        skillTemp.setName(skill.getName());
        skillTemp.setScore(skill.getScore());
        skillTemp.setColor(skill.getColor());
        skillTemp.setPersona(skill.getPersona());
        
        
        skillServ.saveSkill(skillTemp);
        return new ResponseEntity<Skill>(skillTemp, HttpStatus.OK);        
    }
    
    @DeleteMapping ("skill/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        skillServ.deleteSkill(id);
        return new ResponseEntity<String>("Skill is deleted successfully.!", HttpStatus.OK);
    }
}