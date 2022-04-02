package com.portfolio.hermosilla.Service;

import com.portfolio.hermosilla.DTO.PersonaDTO;
import com.portfolio.hermosilla.Model.Persona;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IPersonaService {
    public List<Persona> getPersona();
    public Persona savePersona(Persona persona);
    public Persona savePersonaDTO(PersonaDTO persona);
    public void deletePersona(Long id);
    public Persona findPersona(Long id);
    
}
