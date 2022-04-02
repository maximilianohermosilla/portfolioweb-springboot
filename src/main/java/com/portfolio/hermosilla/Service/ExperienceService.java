package com.portfolio.hermosilla.Service;

import com.portfolio.hermosilla.Model.Experience;
import com.portfolio.hermosilla.Model.Persona;
import com.portfolio.hermosilla.Repository.ExperienceRepository;
import com.portfolio.hermosilla.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService{

    @Autowired
    private ExperienceRepository expRepo;
    
    @Autowired
    private PersonaRepository personaRepo;
    
    @Override
    public List<Experience> getExperience() {
        List<Experience> listaExp = expRepo.findAll();
        return listaExp;
    }

    @Override
    public Experience saveExperience(Experience experience) {
        expRepo.save(experience);
        return experience;
    }

    @Override
    public void deleteExperience(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experience findExperience(Long id) {
        Experience expTemp = expRepo.findById(id).orElse(null);
        return expTemp;
    }
    
    @Override
    public List<Experience> getExperiencePersona(Long idPersona) {
        List<Experience> lista = expRepo.findByPersona(idPersona);
        return lista;
    }
    
    @Override
    public Experience saveExperienceId(Long idPersona, Experience experience) {
        Persona persona = personaRepo.findById(idPersona).orElse(null);;
        experience.setPersona(persona);       
        
        expRepo.save(experience);
        return experience;
    }
}
