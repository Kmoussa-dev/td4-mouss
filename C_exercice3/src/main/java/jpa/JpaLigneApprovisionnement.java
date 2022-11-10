package jpa;

import entities.Gestionnaire;

public class JpaLigneApprovisionnement{

    private Gestionnaire gestionnaire;

    public JpaLigneApprovisionnement(Gestionnaire gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    public Gestionnaire getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(Gestionnaire gestionnaire) {
        this.gestionnaire = gestionnaire;
    }
}
