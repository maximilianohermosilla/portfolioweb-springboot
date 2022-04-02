package com.portfolio.hermosilla.Service;

import com.portfolio.hermosilla.Model.Skill;
import java.util.List;
import org.springframework.stereotype.Service;

@Service        
public interface ISkillService {
    public List<Skill> getSkill();
    public List<Skill> getSkillPersona(Long idPersona);
    public Skill saveSkill(Skill skill);
    public Skill saveSkillId(Long idPersona, Skill skill);
    public void deleteSkill(Long id);
    public Skill findSkill(Long id);    
}
