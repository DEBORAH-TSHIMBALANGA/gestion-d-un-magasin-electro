package data;

import repository.EmployeRepository;
import repository.OrdinateurRepository;
import repository.TelephoneRepository;
import repository.CommandeRepository;

import java.util.List;

public class Main {

    private static final String databaseUrl = "data/gestion_produits.db";

    public static void main(String[] args) {
        // Initialiser la base de données SQLite
        persistance.SQLiteDatabaseInitializer.initializeDatabase(databaseUrl);

        // Initialisation des repositories
        EmployeRepository employeRepo = new EmployeRepository(databaseUrl);
        OrdinateurRepository ordinateurRepo = new OrdinateurRepository(databaseUrl);
        TelephoneRepository telephoneRepo = new TelephoneRepository(databaseUrl);
        CommandeRepository commandeRepo = new CommandeRepository(databaseUrl);

        // Ajouter des employés
        employeRepo.addEmploye("Jane Smith", "jane@company.com", "Manager");
        employeRepo.addEmploye("John Doe", "john.doe@company.com", "Technicien");

        // Afficher tous les employés
        System.out.println("\nListe des employés :");
        employeRepo.getAllEmployes().forEach(System.out::println);

        // Ajouter un ordinateur
        ordinateur ordinateur1 = new ordinateur(
                1, "MacBook Pro", 2400.99f, "M1 Pro", 10,
                "Ordinateur puissant", "16GB", "13 pouces"
        );
        ordinateurRepo.addOrdinateur(
                ordinateur1.getProcesseur(),
                ordinateur1.getMemoireRam(),
                ordinateur1.getTaiileEcrant()
        );

        // Afficher tous les ordinateurs
        System.out.println("\nListe des ordinateurs :");
        ordinateurRepo.getAllOrdinateurs().forEach(System.out::println);

        // Ajouter un téléphone
        telephone telephone1 = new telephone(
                2, "iPhone 14", 1299.99f, "Dernière version",
                5, "Apple", "iOS", 128
        );
        telephoneRepo.addTelephone(
                telephone1.getMarque(),
                telephone1.getSysteme(),
                telephone1.getMemoire()
        );

        // Afficher tous les téléphones
        System.out.println("\nListe des téléphones :");
        telephoneRepo.getAllTelephones().forEach(System.out::println);

        // Ajouter une commande
        commande commande1 = new commande(1, "2025-03-30", "Ordinateur Portable");
        commandeRepo.addCommande(commande1.getProduitCommande(), commande1.getDateCommande());

        // Afficher toutes les commandes
        System.out.println("\nListe des commandes :");
        commandeRepo.getAllCommandes().forEach(System.out::println);
    }
}