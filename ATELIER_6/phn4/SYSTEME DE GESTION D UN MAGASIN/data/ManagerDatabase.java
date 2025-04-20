package persistance;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteDatabaseInitializer {

    /**
     * Initialise la base de données SQLite.
     * - Vérifie si le fichier de base de données existe, sinon le crée.
     * - Crée les tables si elles n'existent pas.
     */
    public static void initializeDatabase(String databaseUrl) {
        try {
            // 1. Vérifie et force la création du fichier de base de données
            createDatabaseFileIfNotExists(databaseUrl);

            // 2. Crée les tables nécessaires
            createTables(databaseUrl);

        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'initialisation de la base de données", e);
        }
    }

    private static void createDatabaseFileIfNotExists(String databaseUrl) {
        File databaseFile = new File(databaseUrl);

        if (!databaseFile.exists()) {
            try {

                File parentDir = databaseFile.getParentFile();
                if (parentDir != null && !parentDir.exists() && !parentDir.mkdirs()) {
                    throw new RuntimeException("Impossible de créer le dossier parent pour la base de données : " + parentDir.getPath());
                }

                try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl)) {
                    System.out.println("Base de données créée dans : " + databaseUrl);
                }

            } catch (SQLException e) {
                throw new RuntimeException("Impossible de créer le fichier SQLite", e);
            }
        }
    }

    private static void createTables(String databaseUrl) {
        String createTableEmploye = """
        CREATE TABLE IF NOT EXISTS employe (
            idEmploye INTEGER PRIMARY KEY AUTOINCREMENT,
            nom TEXT NOT NULL,
            email TEXT NOT NULL UNIQUE,
            role TEXT NOT NULL
        );
    """;

        String createTableOrdinateur = """
        CREATE TABLE IF NOT EXISTS ordinateur (
            processeur TEXT NOT NULL,
            memoireRam TEXT NOT NULL,
            taiileEcrant TEXT NOT NULL,

        );
    """;

        String createTableTelephone= """
        CREATE TABLE IF NOT EXISTS telephone (
            marque TEXT NOT NULL UNIQUE,
            systeme TEXT NOT NULL,
            memoire INT NOT NULL
        );
    """;
        String createTableCommandes = """
        CREATE TABLE IF NOT EXISTS Commandes (
            idCommande INTEGER PRIMARY KEY AUTOINCREMENT,
            produitCommande TEXT NOT NULL,
            dateCommande TEXT NOT NULL,
           
        );
    """;


        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
             Statement statement = connection.createStatement()) {
            statement.execute(createTableCommandes  );
            statement.execute(createTableTelephone);
            statement.execute(createTableOrdinateur);
            statement.execute(createTableEmploye);


            System.out.println("Tables nécessaires ont été vérifiées ou créées avec succès.");
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la création des tables dans la base de données", e);
        }
    }
}