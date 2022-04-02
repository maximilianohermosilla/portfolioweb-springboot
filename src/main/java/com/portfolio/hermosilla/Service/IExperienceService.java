package com.portfolio.hermosilla.Service;

import com.portfolio.hermosilla.Model.Experience;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IExperienceService {
    public List<Experience> getExperience();
    public List<Experience> getExperiencePersona(Long idPersona);
    public Experience saveExperience(Experience experience);
    public Experience saveExperienceId(Long idPersona, Experience experience);
    public void deleteExperience(Long id);
    public Experience findExperience(Long id);    
}
