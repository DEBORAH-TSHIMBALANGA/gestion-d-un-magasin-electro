package data;

public class telephone extends Produit {
    private String marque ;
    private String systeme;
    private int memoire;

    public telephone(int idproduit,String nom, float prix,String description,int quantite,String marque,String systeme,int memoire){
        super(idproduit,nom,prix,description,quantite);
        this.marque=marque;
        this.memoire=memoire;
        this.systeme=systeme;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }


    public String getSysteme() {
        return systeme;
    }

    public void setSysteme(String systeme) {
        this.systeme = systeme;
    }

    public int getMemoire() {
        return memoire;
    }

    public void setMemoire(int memoire) {
        this.memoire = memoire;
    }

    public void afficherDetail(){
        System.out.println("marque:"+ marque +",systeme:"+systeme+",memoire:"+memoire+",prix:"+getPrix());


    }
}
