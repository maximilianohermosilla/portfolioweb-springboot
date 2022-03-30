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
public class Education {
    
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private Long id;
    private String school;
    private String title;
    private String image;
    private String career;
    private String score;
    private String start;
    private String end;
    
    @OneToOne (fetch=FetchType.LAZY)    
    @JoinColumn (name="idPersona")
    @JsonIgnore
    private Persona persona;

    public Education() {
    }

    public Education(Long id, String school, String title, String image, String career, String score, String start, String end, Long idpersona) {
        this.id = id;
        this.school = school;
        this.title = title;
        this.image = image;
        this.career = career;
        this.score = score;
        this.start = start;
        this.end = end;
    }

    public Education(String school, String title, String image, String career, String score, String start, String end, Persona persona) {
        this.school = school;
        this.title = title;
        this.image = image;
        this.career = career;
        this.score = score;
        this.start = start;
        this.end = end;
        this.persona = persona;
    }
    
    
    
}
