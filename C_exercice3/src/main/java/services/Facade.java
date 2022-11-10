package services;

import jpa.JpaCategorie;
import jpa.JpaLigneVente;
import entities.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class Facade {
    @PersistenceContext
    EntityManager em;

    /**
     * Renvoie le produit dont l'id est fourni. et null si non trouvé.
     * @param idProduit
     * @return
     */
    public Produit findById(int idProduit) {
        Query query= em.createQuery("select p from Produit p where p.idProduit = :idProduit");
        query.setParameter("idProduit",idProduit);
        Produit produit= (Produit) query.getSingleResult();
        if (Objects.isNull(produit)) return null;
        return produit;
    }

    /**
     * Renvoie le nom du produit correspondant à la plus grosse ligne de vente
     * @return
     */
    public String  nomProduitPlusGrosseLigne(){
        Query query= em.createQuery("select new jpa.JpaLigneVente(max(lv.quantite),lv.produit) from LigneVente lv");
        JpaLigneVente jpaLigneVenteProduit = (JpaLigneVente) query.getSingleResult();
        return jpaLigneVenteProduit.getProduit().getNomProduit();
    }

    /**
     * Renvoie le produit dont les ventes sont les plus grandes en nombre d'unité (en quantité)
     * VOUS NE POURREZ PAS LE FAIRE DIRECTEMENT EN JPQL OU SQL : PASSEZ PAR UNE VUE DANS LA BD ET UNE REQUETE NATIVE
     * OU PAR UN PEU DE TRAITEMENT EN JAVA...
     * @return
     */
    public Produit plusGrosseVenteQuantite() {
        Query query = em.createQuery("select new jpa.JpaLigneVente(max (lv.quantite),lv.produit) from LigneVente lv");
        JpaLigneVente jpaLigneVente=(JpaLigneVente) query.getSingleResult();
        return jpaLigneVente.getProduit();
    }

    /**
     * Renvoie le produit dont les ventes génèrent le plus gros chiffre d'affaire (quantité * prix unitaire)
     * VOUS NE POURREZ PAS LE FAIRE DIRECTEMENT EN JPQL OU SQL : PASSEZ PAR UNE VUE DANS LA BD ET UNE REQUETE NATIVE
     * OU PAR UN PEU DE TRAITEMENT EN JAVA...
     * @return
     */
    public Produit plusGrosseVenteMontant() {
        Query query = em.createQuery("select new jpa.JpaLigneVente(lv.quantite,lv.produit) from LigneVente lv");
        List<JpaLigneVente> jpaLigneVentes = query.getResultList();
        return jpaLigneVentes.stream()
                .max(Comparator.comparingDouble(JpaLigneVente::getChiffreDAffaire))
                .get()
                .getProduit();

    }

    /**
     * Renvoie la liste des produits dont le stock est inférieur ou égal à stockMini
     * @param stockMini
     * @return
     */
    public List<Produit> stockSous(int stockMini) {
        Query query=em.createQuery("select p from Produit p where p.stock > :stockMini");
        query.setParameter("stockMini",stockMini);
        return query.getResultList();
    }

    /**
     * Renvoie la liste des ventes comportant le produit dont l'id est en paramètre
     * @param idProduit
     * @return
     */
    public List<Vente> ventesDe(int idProduit) {
        Query query=em.createQuery("select lv from LigneVente lv where lv.produit.idProduit=:idProduit");
        query.setParameter("idProduit",idProduit);
        List<LigneVente> ligneVentes=query.getResultList();
        return ligneVentes.stream()
                .map(LigneVente::getVente)
                .collect(Collectors.toList());
    }

      /**
     * Renvoie la liste ** dates de commande *** des ventes comportant le produit dont l'id est en paramètre
     * @param idProduit
     * @return
     */
    public List<LocalDate> datesVentesDe(int idProduit) {
        Query query=em.createQuery("select lv from LigneVente lv where lv.produit.idProduit=:idProduit");
        query.setParameter("idProduit",idProduit);
        List<LigneVente> ligneVentes=query.getResultList();
        return ligneVentes.stream()
                .map(l->l.getVente().getDateCmd())
                .collect(Collectors.toList());
    }

    /**
     * Renvoie la liste des produits qui n'ont jamais été vendus (aucune vente)
     * @return
     */
    public List<Produit> produitsNonVendus() {
        Query q=em.createQuery("Select p From Produit p where p not in (select lv.produit From LigneVente lv)");
        return q.getResultList();
    }

    /**
     * Renvoie les gestionnaires qui ont déjà passé des demandes d'approvisionnement pour le produit en paramètre
     * @param idProduit
     * @return
     */
    public List<Gestionnaire> acheteurDe(int idProduit){
        Query query=em.createQuery("select new jpa.JpaLigneApprovisionnement(la.approvisionnement.gestionnaire) from LigneApprovisionnement la");
        return query.getResultList();
    }

    /**
     * Renvoie le produit le moins cher de la catégorie indiquée.
     * @param idCategorie
     * @return
     */
    public Produit moinsCherDe(int idCategorie) {
        Query query=em.createQuery("select new jpa.JpaCategorie(c.produits) from Categorie c where c.idCategorie=:idCategorie");
        query.setParameter("idCategorie",idCategorie);
        List<JpaCategorie> categories= query.getResultList();
        return categories.stream()
                .map(jpaCategorie -> jpaCategorie.produitmoinchere())
                .collect(Collectors.toList()).get(0);
    }

    /**
     * Renvoie la catégorie du produit indiqué.
     * @param idProduit
     * @return
     */
    public Categorie categorieDe(int idProduit) {
        Query query=em.createQuery("select new jpa.JpaCategorie(p.categorie) from Produit p where p.categorie = :idProduit");
        query.setParameter("idProduit",idProduit);
        JpaCategorie jpaCategorie= (JpaCategorie) query.getSingleResult();
        return jpaCategorie.getCategorie();
    }
}
