package Interface;

import data.Produit;

import java.util.List;

public interface ProduitRepository {
    void save(Produit produit);

    void ajouterProduit(Produit produit);
        void supprimerProduit(Produit produit);
        void modifierProduit(Produit produit);

    void save(Produit produit);

    Produit findProduitById(int id);
        List<Produit> getAllProduits();
    }
