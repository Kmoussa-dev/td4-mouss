package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Service {
    @Id
    private int idService;
    private String nomService;
    @OneToMany(mappedBy = "service")
    private List<Employe> membres;

    public int getIdService() {
        return idService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public List<Employe> getMembres() {
        return membres;
    }

    public void setMembres(List<Employe> membres) {
        this.membres = membres;
    }
}
