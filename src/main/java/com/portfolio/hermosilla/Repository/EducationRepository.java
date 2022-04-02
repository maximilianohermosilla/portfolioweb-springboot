package com.portfolio.hermosilla.Repository;

import com.portfolio.hermosilla.Model.Education;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long>{
    
    
    @Query(value = "SELECT * FROM Education e WHERE e.id_persona = :idPersona", nativeQuery=true)
        List<Education> findByPersona(@Param("idPersona") Long idPersona);
}
