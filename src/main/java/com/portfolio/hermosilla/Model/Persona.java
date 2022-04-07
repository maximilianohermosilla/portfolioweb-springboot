package com.portfolio.hermosilla.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String profilePhoto;
    private String image;
    private String position;
    private String ubication;    
    private String about;
    
    @OneToOne (fetch=FetchType.EAGER)    
    @JoinColumn (name="id_company", nullable=true)
    //@JsonIgnore
    private Experience company;
    
    @OneToOne (fetch=FetchType.EAGER)    
    @JoinColumn (name="id_school", nullable=true)
    //@JsonIgnore
    private Education school;
    
    @OneToMany(
            mappedBy = "persona",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Education> education = new ArrayList<>();
    
    @OneToOne(mappedBy="persona")
    @JsonIgnore
    private Usuario usuario;
    

    public Persona() {
    }

    public Persona(Long id, String name, String profilePhoto, String image, String position, String ubication, String about) {
        this.id = id;
        this.name = name;
        this.profilePhoto = profilePhoto;
        this.image = image;
        this.position = position;
        this.ubication = ubication;
        this.about = about;
    }

    public Persona(String name, String profilePhoto, String image, String position, String ubication, String about) {
        this.name = name;
        this.profilePhoto = profilePhoto;
        this.image = image;
        this.position = position;
        this.ubication = ubication;
        this.about = about;
    }
    
    public Persona(Long id, String name, String profilePhoto, String image, String position, String ubication, String about, Experience company, Education school) {
        this.id = id;
        this.name = name;
        this.profilePhoto = profilePhoto;
        this.image = image;
        this.position = position;
        this.ubication = ubication;
        this.about = about;
        this.company = company;
        this.school = school;
    }

    public Persona(String name) {
        this.name = name;
    }
    
    
    
    
}
