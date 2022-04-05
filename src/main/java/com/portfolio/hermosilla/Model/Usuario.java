package com.portfolio.hermosilla.Model;

import com.sun.istack.NotNull;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @NotNull
    @Column (unique=true)
    private String user;
    private String name;
    private String password;
    private Boolean habilitado;
    
    @ManyToMany (fetch=FetchType.EAGER)    
    @JoinTable(name="perfiles_usuarios", joinColumns= @JoinColumn(name="id_usuario"),
    inverseJoinColumns = @JoinColumn(name="id_perfil"))
    private Set<Perfil> perfiles = new HashSet<>();
    
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

    public Usuario(String user, String name, String password, Boolean habilitado) {
        this.user = user;
        this.name = name;
        this.password = password;
        this.habilitado = habilitado;
    }
    
    
}
