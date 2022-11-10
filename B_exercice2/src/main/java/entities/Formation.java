package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Formation {

    @Id
    private String idForm;

    private String intituleForm;

    @ManyToMany
    @JoinTable(name= "reserve",
            joinColumns={@JoinColumn(name= "idForm")},
            inverseJoinColumns= {@JoinColumn(name= "idSalle")})
    private List<Salle> reserve;

    @ManyToMany(mappedBy = "inscrits")
    private List<Etudiant> inscritEn;

    @ManyToMany
    @JoinTable(name= "groupes",
            joinColumns={@JoinColumn(name= "idForm")},
            inverseJoinColumns= {@JoinColumn(name= "idGroupe")})
    private List<Groupe> groupes;

    public Formation() {
    }
}
