package data;

public class client {
    private int idClient;
    private String nom;
    private String telephone;
    private String email;



    public client(int idClient,String nom,String telephone,String email){
        this.nom=nom;
        this.telephone=telephone;
        this.idClient=idClient;
        this.email=email;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void passerCommande(){
        System.out.println(nom +"passer data.commande");

    }

}
