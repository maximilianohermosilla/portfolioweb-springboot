package com.portfolio.hermosilla.Repository;

import com.portfolio.hermosilla.Model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    Optional<Usuario> findByUser(String user);
    boolean existsByUser(String user);
    boolean existsByName(String name);
    
    
}
