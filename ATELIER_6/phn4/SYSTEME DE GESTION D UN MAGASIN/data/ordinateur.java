package data;

public class ordinateur extends Produit {
    private String processeur;
    private String memoireRam;
    private String taiileEcrant;

    public ordinateur(int idProduit ,String nom,float prix,String processeur,int quantite,String description,String memoireRam,String taiileEcrant){
        super(idProduit, nom, prix, description, quantite);
        this.processeur=processeur;
        this.memoireRam=memoireRam;
        this.taiileEcrant=taiileEcrant;

    }

    public String getProcesseur() {
        return processeur;
    }

    public void setProcesseur(String processeur) {
        this.processeur = processeur;
    }

    public String getMemoireRam() {
        return memoireRam;
    }

    public void setMemoireRam(String memoireRam) {
        this.memoireRam = memoireRam;
    }

    public String getTaiileEcrant() {
        return taiileEcrant;
    }

    public void setTaiileEcrant(String taiileEcrant) {
        this.taiileEcrant = taiileEcrant;
    }

    public void afficherDetail(){
        System.out.println("processeur:"+ processeur +",memoire:"+memoireRam+",tailleECcant:"+taiileEcrant+",prix:"+getPrix());

    }
}
