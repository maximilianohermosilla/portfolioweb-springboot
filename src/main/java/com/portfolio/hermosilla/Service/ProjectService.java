package com.portfolio.hermosilla.Service;

import com.portfolio.hermosilla.Model.Project;
import com.portfolio.hermosilla.Repository.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService{

    @Autowired
    private ProjectRepository projectRepo;
    @Override
    public List<Project> getProject() {
        List<Project> listaProject = projectRepo.findAll();
        return listaProject;
    }

    @Override
    public Project saveProject(Project project) {
        projectRepo.save(project);
        return project;
    }

    @Override
    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }

    @Override
    public Project findProject(Long id) {
        Project projectTemp = projectRepo.findById(id).orElse(null);
        return projectTemp;
    }
    
}
