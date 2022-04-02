package com.portfolio.hermosilla.Repository;

import com.portfolio.hermosilla.Model.Project;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
    
    @Query(value = "SELECT * FROM Project e WHERE e.id_persona = :idPersona", nativeQuery=true)
        List<Project> findByPersona(@Param("idPersona") Long idPersona);
        
}
