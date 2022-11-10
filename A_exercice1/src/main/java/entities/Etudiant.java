package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Etudiant {

    @Id
    private String numEtu;

    private String nom;

    private String prenom;

    @ManyToMany
    @JoinTable(name= "inscrts",
            joinColumns={@JoinColumn(name= "numEtu")},
                    inverseJoinColumns={@JoinColumn(name= "idForm")})
    private List<Formation> inscrits;

    @ManyToMany
    @JoinTable(name= "appartient",
            joinColumns={@JoinColumn(name= "numEtu")},
            inverseJoinColumns={@JoinColumn(name= "idGroupe")})
    private List<Groupe> appartient;

    public Etudiant() {
    }
}
