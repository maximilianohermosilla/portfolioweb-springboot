package com.portfolio.hermosilla.Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    
    /*@OneToMany(
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )*/
    //private List<Education> education = new ArrayList<>();   
    

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
    
    
    
}
