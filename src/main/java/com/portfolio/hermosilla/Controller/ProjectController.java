package com.portfolio.hermosilla.Controller;

import org.springframework.http.HttpStatus;
import com.portfolio.hermosilla.Model.Project;
import com.portfolio.hermosilla.Service.IPersonaService;
import com.portfolio.hermosilla.Service.IProjectService;
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
public class ProjectController {
    
    @Autowired
    private IProjectService projectServ;
    
    @Autowired
    private IPersonaService personaServ;
    
    @GetMapping ("project")
    public ResponseEntity<List<Project>> get(){
        List<Project> projects = projectServ.getProject();
        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
    }
    
    @GetMapping ("projectPersona/{idPersona}")
    public ResponseEntity<List<Project>> getProjectPersona(@PathVariable Long idPersona){
        List<Project> projects = projectServ.getProjectPersona(idPersona);
        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
    }
    
    @PostMapping ("project")
    public ResponseEntity<Project> save(@RequestBody Project project) {
        Project projectTemp = projectServ.saveProject(project);
        return new ResponseEntity<Project>(projectTemp, HttpStatus.OK);
    }
    
    @PostMapping ("projectPersona/{idPersona}")
    public ResponseEntity<Project> saveProjectPersona(@PathVariable(value = "idPersona") Long idPersona,
                                                          @RequestBody Project project) {
		Project projectTemp = projectServ.saveProjectId(idPersona, project);
		return new ResponseEntity<Project>(projectTemp, HttpStatus.OK);
    }
    
    @PutMapping ("project/{id}")
    public ResponseEntity<Project> edit(@PathVariable Long id,
                                     @RequestBody Project project){
        Project projectTemp = projectServ.findProject(id);
        projectTemp.setName(project.getName());
        projectTemp.setStart(project.getStart());
        projectTemp.setDescription(project.getDescription());
        projectTemp.setUrl(project.getUrl());
        projectTemp.setImg(project.getImg());
        
        
        projectServ.saveProject(projectTemp);
        return new ResponseEntity<Project>(projectTemp, HttpStatus.OK);        
    }
    
    @DeleteMapping ("project/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        projectServ.deleteProject(id);
        return new ResponseEntity<String>("Project is deleted successfully.!", HttpStatus.OK);
    }
}