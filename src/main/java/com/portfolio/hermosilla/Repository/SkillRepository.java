package com.portfolio.hermosilla.Repository;

import com.portfolio.hermosilla.Model.Skill;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{
    
    @Query(value = "SELECT * FROM Skill e WHERE e.id_persona = :idPersona", nativeQuery=true)
        List<Skill> findByPersona(@Param("idPersona") Long idPersona);
    
}
