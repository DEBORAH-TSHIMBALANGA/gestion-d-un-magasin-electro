package data.persistance;

import data.Produit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ProduitFileRepository {
    String filename;
    private List<Produit> produits;

    public ProduitFileRepository(String filename) {

        this.filename = filename;

    }
    @Override
    public void save (List<Produit> produits){
        this.produits = produits;

        try {
            ObjectOutputStream enregistreurObjet;
            FileOutputStream enregistreurFichier=new FileOutputStream(filename);
            enregistreurObjet=new ObjectOutputStream(enregistreurFichier);
            enregistreurObjet.writeObject(produits);



        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Produit> load() {
        try {
            ObjectInputStream chargeur;
            FileInputStream chargeurFichier=new FileInputStream(filename);
            chargeur= new ObjectInputStream(chargeurFichier);
            List<Produit> produits=(List<Produit>) chargeur.readObject();
            return produits ;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}



}
