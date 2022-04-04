package com.portfolio.hermosilla.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Experience {
    
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private Long id;
    private String company;
    private String position;
    private String img;
    private String mode;
    private String start;
    private String end;
    private String timeElapsed;
    private String ubication;
        
    @ManyToOne (fetch=FetchType.LAZY)    
    @JoinColumn (name="id_persona", nullable=false)
    @JsonIgnore
    private Persona persona;
    
    @OneToOne(mappedBy="company")
    @JsonIgnore
    private Persona id_company;

    public Experience(Long id, String company, String position, String img, String mode, String start, String end, String timeElapsed, String ubication, Persona persona, Long id_persona) {
        this.id = id;
        this.company = company;
        this.position = position;
        this.img = img;
        this.mode = mode;
        this.start = start;
        this.end = end;
        this.timeElapsed = timeElapsed;
        this.ubication = ubication;
        this.persona = persona;
    }

    public Experience() {
    }

    public Experience(Long id, String company, String position, String img, String mode, String start, String end, String timeElapsed, String ubication, Persona persona) {
        this.id = id;
        this.company = company;
        this.position = position;
        this.img = img;
        this.mode = mode;
        this.start = start;
        this.end = end;
        this.timeElapsed = timeElapsed;
        this.ubication = ubication;
        this.persona = persona;
    }

    public Experience(String company, String position, String img, String mode, String start, String end, String timeElapsed, String ubication, Persona persona) {
        this.company = company;
        this.position = position;
        this.img = img;
        this.mode = mode;
        this.start = start;
        this.end = end;
        this.timeElapsed = timeElapsed;
        this.ubication = ubication;
        this.persona = persona;
    }
    
    
}
