package data;

public class commande {
    private int idCommande;
    private String dateCommande;
    private String produitCommande;

    public commande(int idCommande,String dateCommande,String produitCommande ){
        this.dateCommande=dateCommande;
        this.produitCommande=produitCommande;
        this.idCommande=idCommande;


    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getProduitCommande() {
        return produitCommande;
    }

    public void setProduitCommande(String produitCommande) {
        this.produitCommande = produitCommande;
    }

    public void calculerCommande(){
        System.out.println("calcul prix data.commande");

    }
    public void modifierCommande(){
        System.out.println("modifier la data.commande");

    }

    public void afficherDetail() {
        System.out.println("data.commande ID:"+ idCommande +",date:"+dateCommande+",produit:"+produitCommande);

    }
}

