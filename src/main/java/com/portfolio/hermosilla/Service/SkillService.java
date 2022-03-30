package com.portfolio.hermosilla.Service;

import com.portfolio.hermosilla.Model.Skill;
import com.portfolio.hermosilla.Repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService{
    
    @Autowired
    private SkillRepository skillRepo;

    @Override
    public List<Skill> getSkill() {
        List<Skill> listaSkill = skillRepo.findAll();
        return listaSkill;        
        
    }

    @Override
    public Skill saveSkill(Skill skill) {
        skillRepo.save(skill);
        return skill;
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skill findSkill(Long id) {
        Skill skillTemp = skillRepo.findById(id).orElse(null);
        return skillTemp;
    }
    
    
}
