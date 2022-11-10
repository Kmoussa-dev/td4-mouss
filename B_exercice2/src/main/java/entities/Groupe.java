package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Groupe {
    @Id
    private int idGroupe;

    private String intitule;

    @ManyToMany(mappedBy = "appartient")
    private List<Membres> membres;

    @ManyToMany(mappedBy = "groupes")
    private List<Formation> etudiantsDe;

    @OneToMany(mappedBy = "concerne")
    private List<Creneau> creneaux;
}
