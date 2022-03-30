package com.portfolio.hermosilla.Service;

import com.portfolio.hermosilla.Model.Education;
import com.portfolio.hermosilla.Repository.EducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService{
    
    @Autowired
    private EducationRepository educationRepo;

    @Override
    public List<Education> getEducation() {
        List<Education> listaEdu = educationRepo.findAll();
        return listaEdu;
    }

    @Override
    public Education saveEducation(Education education) {
        educationRepo.save(education);
        return education;
    }

    @Override
    public void deleteEducation(Long id) {
        educationRepo.deleteById(id);
    }

    @Override
    public Education findEducation(Long id) {
        Education educationTemp = educationRepo.findById(id).orElse(null);
        return educationTemp;
    }
    
    
    
}
