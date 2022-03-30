package com.portfolio.hermosilla.Repository;

import com.portfolio.hermosilla.Model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long>{
    
}
