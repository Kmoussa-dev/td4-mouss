package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Creneau {

    @Id
    private int idCreneau;

    private LocalDateTime debut;

    private LocalDateTime fin;

    @ManyToOne
    private Salle dans;

    @ManyToOne
    private Groupe concerne;

}
