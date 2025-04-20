package data;

import java.io.Serializable;

public abstract class Produit implements Serializable {
    private static long serialiversionUID=1L;
    private int idProduit;
    private String nom;
    private float prix;
    private String description;
    private int quantite;

    public Produit(int idProduit,String nom,float prix,String description,int quantite){
        this.idProduit=idProduit;
        this.nom=nom;
        this.prix=prix;
        this.description=description;
        this.quantite=quantite;

    }

    public Produit() {

    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void ajouterProduit(){
        this.quantite+=quantite;

    }
    public void supprimerProduit(){
        if(this.quantite>=quantite){
            this.quantite-=quantite;
        } else{
            System.out.println("Quantite insuffissante");

        }


    }
    public void mettraAjour(){

}
public void modifierPrixProd(){



}
}
