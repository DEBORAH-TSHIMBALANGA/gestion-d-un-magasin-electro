package data;

public class accessoires extends Produit {
    private String typeAccessoire;
    private int prix;


    public accessoires(int idProduit,String nom,float prix,String description,int quantite,String type){
        super(idProduit, description, prix, nom, quantite);
        this.typeAccessoire=type;


    }

    public String getTypeAccessoire() {
        return typeAccessoire;
    }

    public void setTypeAccessoire(String typeAccessoire) {
        this.typeAccessoire = typeAccessoire;
    }

    @Override
    public float getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void afficherDetails(){
        System.out.println("type:"+ typeAccessoire +",nom:"+getNom()+",prix:"+getPrix()+",description:"+getDescription());

    }


}

