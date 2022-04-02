package com.portfolio.hermosilla.DTO;

import com.portfolio.hermosilla.Model.Education;
import com.portfolio.hermosilla.Model.Experience;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonaDTO implements Serializable{
    
    private Long id;
    private String name;
    private String profilePhoto;
    private String image;
    private String position;
    private String ubication;
    private String about;
    private Experience company;
    private Education school;

    public PersonaDTO(Long id, String name, String profilePhoto, String image, String position, String ubication, String about, Experience company, Education school, List<Experience> experience, List<Education> education) {
        this.id = id;
        this.name = name;
        this.profilePhoto = profilePhoto;
        this.image = image;
        this.position = position;
        this.ubication = ubication;
        this.about = about;
        this.company = company;
        this.school = school;
        this.experience = experience;
        this.education = education;
    }
    private List<Experience> experience;
    private List<Education> education;

    public PersonaDTO() {
    }

    public PersonaDTO(Long id, String name, String profilePhoto, String image, String position, String ubication, String about, List<Experience> experienceList, List<Education> educationList) {
        this.id = id;
        this.name = name;
        this.profilePhoto = profilePhoto;
        this.image = image;
        this.position = position;
        this.ubication = ubication;
        this.about = about;
        this.experience = experienceList;
        this.education = educationList;
    }

    public PersonaDTO(String name, String profilePhoto, String image, String position, String ubication, String about, List<Experience> experienceList, List<Education> educationList) {
        this.name = name;
        this.profilePhoto = profilePhoto;
        this.image = image;
        this.position = position;
        this.ubication = ubication;
        this.about = about;
        this.experience = experienceList;
        this.education = educationList;
    }

    public PersonaDTO(Long id, String name, String profilePhoto, String image, String position, String ubication, String about, Experience company, Education school) {
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
    
    
}
