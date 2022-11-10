package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Membres {

    @Id
    private int idMembre;

    @ManyToMany
    @JoinTable(name= "membres",
            joinColumns={@JoinColumn(name= "idMembre")},
            inverseJoinColumns={@JoinColumn(name= "idGroupe")})
    private List<Groupe> appartient;
}
