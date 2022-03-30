package com.portfolio.hermosilla.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity   
public class Project {
    
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String start;
    private String description;
    private String url;
    private String img;
    
    @OneToOne (fetch=FetchType.EAGER)    
    @JoinColumn (name="idPersona")
    private Persona persona;

    public Project() {
    }

    public Project(Long id, String name, String start, String description, String url, String img, Persona persona) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.description = description;
        this.url = url;
        this.img = img;
        this.persona = persona;
    }
    
    public Project(String name, String start, String description, String url, String img, Persona persona) {
        this.name = name;
        this.start = start;
        this.description = description;
        this.url = url;
        this.img = img;
        this.persona = persona;
    }
    
}
