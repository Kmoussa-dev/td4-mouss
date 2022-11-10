package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class UFR {

    @Id
    private int idUFR;

    private String sigleUFR;

    @OneToMany(mappedBy = "batiments")
    private List<Batiment> gerePar;

    public int getIdUFR() {
        return idUFR;
    }

    public void setIdUFR(int idUFR) {
        this.idUFR = idUFR;
    }

    public String getSigleUFR() {
        return sigleUFR;
    }

    public void setSigleUFR(String sigleUFR) {
        this.sigleUFR = sigleUFR;
    }

    public List<Batiment> getGerePar() {
        return gerePar;
    }

    public void setGerePar(List<Batiment> gerePar) {
        this.gerePar = gerePar;
    }
}
