package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Adresse {
    @Id @GeneratedValue
    private int idAdresse;
    private String rue;
    private String codepostal;
    private String ville;
    @ManyToOne
    private Pays pays;
}
