package com.portfolio.hermosilla.Service;

import com.portfolio.hermosilla.Model.Experience;
import com.portfolio.hermosilla.Repository.ExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService{

    @Autowired
    private ExperienceRepository expRepo;
    
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
    /*public void saveExperience(Experience experience) {
        expRepo.save(experience);
    }*/

    @Override
    public void deleteExperience(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experience findExperience(Long id) {
        Experience expTemp = expRepo.findById(id).orElse(null);
        return expTemp;
    }
    
}
