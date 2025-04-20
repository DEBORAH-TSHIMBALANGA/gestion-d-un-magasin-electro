package data;

public class employe {
    private int idEmploye;
    private String nom;
    private String role;
    private String email;


    public employe(int idEmploye,String nom ,String role,String email){
        this.idEmploye=idEmploye;
        this.email=email;
        this.nom=nom;
        this.role=role;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void gererProduit(){
        System.out.println(nom +"gere un produit");

    }
    public void modifierPrixProd(){
        System.out.println(nom +"modifier prix  d un produit");


    }
}
