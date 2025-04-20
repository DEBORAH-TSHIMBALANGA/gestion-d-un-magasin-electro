package Interface;

import data.commande;

import java.util.List;

public interface commandeRepository {
    void ajouterCommande(Commande commande);
        void modifierCommande(Commande commande);

    void save(commande commande);

    List<commande> load();

    void ajouterCommande(commande commande);

    void modifierCommande(commande commande);

    commande findCommandeById(int id);
        List<Commande> getAllCommandes();
    }
}
