package com.portfolio.hermosilla.Repository;

import com.portfolio.hermosilla.Model.Experience;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ExperienceRepository extends JpaRepository<Experience, Long>{
    
    @Query(value = "SELECT * FROM experience e WHERE e.id_persona = :idPersona", nativeQuery=true)
        List<Experience> findByPersona(@Param("idPersona") Long idPersona);
    
    
}
