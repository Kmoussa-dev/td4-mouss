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
    @JoinTable(name= "inscrits",
            joinColumns={@JoinColumn(name= "numEtu")},
                    inverseJoinColumns={@JoinColumn(name= "idForm")})
    private List<Formation> inscrits;

    @ManyToMany(mappedBy = "appartient")
    private List<Membres> membres;

    public Etudiant() {
    }
}
