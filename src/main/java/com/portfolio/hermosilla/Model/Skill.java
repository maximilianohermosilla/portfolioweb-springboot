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
public class Skill {
    
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Integer score;
    private String color;
    
    @ManyToOne (fetch=FetchType.LAZY)    
    @JoinColumn (name="id_persona", nullable=false)
    @JsonIgnore
    private Persona persona;

    public Skill() {
    }

    public Skill(Long id, String name, Integer score, String color, Persona persona) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.color = color;
        this.persona = persona;
    }

    public Skill(String name, Integer score, String color, Persona persona) {
        this.name = name;
        this.score = score;
        this.color = color;
        this.persona = persona;
    }
    
    
}
