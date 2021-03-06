package com.portfolio.hermosilla.Service;

import com.portfolio.hermosilla.Model.Project;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IProjectService {
    public List<Project> getProject();
    public Project saveProject(Project project);
    public void deleteProject(Long id);
    public Project findProject(Long id);
}
