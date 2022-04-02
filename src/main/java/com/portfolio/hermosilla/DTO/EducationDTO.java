package com.portfolio.hermosilla.DTO;

import com.portfolio.hermosilla.Model.Persona;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducationDTO implements Serializable{
    
    private Long id;
    private String school;
    private String title;
    private String image;
    private String career;
    private String score;
    private String start;
    private String end;
    private Persona persona;

    public EducationDTO(Long id, String school, String title, String image, String career, String score, String start, String end, Persona persona) {
        this.id = id;
        this.school = school;
        this.title = title;
        this.image = image;
        this.career = career;
        this.score = score;
        this.start = start;
        this.end = end;
        this.persona = persona;
    }

    public EducationDTO() {
    }

    public EducationDTO(Long id, String school, String title, String image, String career, String score, String start, String end) {
        this.id = id;
        this.school = school;
        this.title = title;
        this.image = image;
        this.career = career;
        this.score = score;
        this.start = start;
        this.end = end;
    }
    
}
