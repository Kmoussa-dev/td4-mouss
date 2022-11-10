package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Batiment {

    @Id
    private int idBatiment;

    private String nomBatiment;

    @ManyToOne
    private UFR batiments;

    @OneToMany(mappedBy = "numSalle")
    private List<Salle> salles;

    public int getIdBatiment() {
        return idBatiment;
    }

    public void setIdBatiment(int idBatiment) {
        this.idBatiment = idBatiment;
    }

    public String getNomBatiment() {
        return nomBatiment;
    }

    public void setNomBatiment(String nomBatiment) {
        this.nomBatiment = nomBatiment;
    }

    public UFR getBatiments() {
        return batiments;
    }

    public void setBatiments(UFR batiments) {
        this.batiments = batiments;
    }
}
