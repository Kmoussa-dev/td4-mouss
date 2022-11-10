package entities;

import javax.persistence.*;

@Entity
public class Adresse {
    @Id @GeneratedValue
    private int idAdresse;
    private String rue;
    private String codepostal;
    private String ville;
    @ManyToOne
    @JoinColumn(name = "CODEPAYS")
    private Pays pays;
}
