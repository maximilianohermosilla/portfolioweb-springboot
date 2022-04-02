package com.portfolio.hermosilla.Service;

import com.portfolio.hermosilla.Model.Education;
import com.portfolio.hermosilla.Model.Persona;
import com.portfolio.hermosilla.Repository.EducationRepository;
import com.portfolio.hermosilla.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService{
    
    @Autowired
    private EducationRepository educationRepo;
    
    @Autowired
    private PersonaRepository personaRepo;

    @Override
    public List<Education> getEducation() {
        List<Education> listaEdu = educationRepo.findAll();
        return listaEdu;
    }

    @Override
    public List<Education> getEducationPersona(Long idPersona) {
        List<Education> listaEdu = educationRepo.findByPersona(idPersona);
        return listaEdu;
    }

    @Override
    public Education saveEducation(Education education) {
        educationRepo.save(education);
        return education;
    }
    
    @Override
    public Education saveEducationId(Long idPersona, Education education) {
        Persona persona = personaRepo.findById(idPersona).orElse(null);;
        education.setPersona(persona);       
        
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
