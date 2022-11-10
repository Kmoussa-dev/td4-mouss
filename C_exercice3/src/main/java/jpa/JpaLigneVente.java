package jpa;

import entities.Produit;

public class JpaLigneVente {

    private int quantite;
    private Produit produit;

    private double chiffreDAffaire;

    public JpaLigneVente(int quantite, Produit produit) {
        this.quantite = quantite;
        this.produit = produit;
        this.chiffreDAffaire= this.quantite * this.produit.getPrixVente();
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public double getChiffreDAffaire() {
        return chiffreDAffaire;
    }

    public void setChiffreDAffaire(double chiffreDAffaire) {
        this.chiffreDAffaire = chiffreDAffaire;
    }
}
