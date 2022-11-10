package jpa;

import entities.Categorie;
import entities.Produit;

import java.util.Comparator;
import java.util.List;

public class JpaCategorie {

    private List<Produit> produits;

    private Categorie categorie;
    public JpaCategorie(List<Produit> produits) {
        this.produits = produits;
    }

    public JpaCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public Produit  produitmoinchere(){
       return this.produits.stream().min(Comparator.comparingDouble(Produit::getPrixVente)).get();
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
