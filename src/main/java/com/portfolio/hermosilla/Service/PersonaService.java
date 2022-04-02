package com.portfolio.hermosilla.Service;

import com.portfolio.hermosilla.DTO.PersonaDTO;
import com.portfolio.hermosilla.Model.Persona;
import com.portfolio.hermosilla.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    private PersonaRepository personaRepo;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> listaPersonas = personaRepo.findAll();
        return listaPersonas;
    }

    @Override
    public Persona savePersona(Persona persona) {
        personaRepo.save(persona);
        return persona;
    }
    
    @Override
    public Persona savePersonaDTO(PersonaDTO personaDTO) {
        Persona persona = new Persona(
                personaDTO.getId(),
                personaDTO.getName(),
                personaDTO.getProfilePhoto(),
                personaDTO.getImage(),
                personaDTO.getPosition(),
                personaDTO.getUbication(),
                personaDTO.getAbout(),
                personaDTO.getCompany(),
                personaDTO.getSchool()
                );
        personaRepo.save(persona);
        return persona;
    }

    @Override
    public void deletePersona(Long id) {
        personaRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona personaTemp = personaRepo.findById(id).orElse(null);
        return personaTemp;
    }
    
}
