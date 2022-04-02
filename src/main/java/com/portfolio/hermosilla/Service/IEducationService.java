package com.portfolio.hermosilla.Service;

import com.portfolio.hermosilla.Model.Education;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IEducationService {
    public List<Education> getEducation();
    public List<Education> getEducationPersona(Long idPersona);
    public Education saveEducation(Education education);
    public Education saveEducationId(Long idPersona, Education education);
    public void deleteEducation(Long id);
    public Education findEducation(Long id);
    
}
