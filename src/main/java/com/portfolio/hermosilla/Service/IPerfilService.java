package com.portfolio.hermosilla.Service;

import com.portfolio.hermosilla.Model.Perfil;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IPerfilService {
    public List<Perfil> getPerfil();
    public Perfil savePerfil(Perfil persona);
    public void deletePerfil(Long id);
    public Perfil findPerfil(Long id);
}
