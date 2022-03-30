package com.portfolio.hermosilla.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private Long id;
    private String user;
    private String password;
    private Boolean habilitado;
    
    @OneToOne (fetch=FetchType.EAGER)    
    @JoinColumn (name="idPersona")
    private Persona persona;

    public Usuario() {
    }

    public Usuario(Long id, String user, String password, Boolean habilitado, Persona persona) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.habilitado = habilitado;
        this.persona = persona;
    }

    public Usuario(String user, String password, Boolean habilitado, Persona persona) {
        this.user = user;
        this.password = password;
        this.habilitado = habilitado;
        this.persona = persona;
    }
    
    
}
