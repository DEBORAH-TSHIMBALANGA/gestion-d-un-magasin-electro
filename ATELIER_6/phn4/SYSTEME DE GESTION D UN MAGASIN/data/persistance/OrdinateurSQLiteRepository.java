package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdinateurSQLiteRepository {
    private final String databaseUrl;

    public OrdinateurRepository(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public void addOrdinateur(String processeur, String memoireRam, String tailleEcran) {
        String query = "INSERT INTO ordinateur (processeur, memoireRam, tailleEcrant) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, processeur);
            statement.setString(2, memoireRam);
            statement.setString(3, tailleEcran);
            statement.executeUpdate();

            System.out.println("Ordinateur ajouté avec succès.");

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'ajout de l'ordinateur.", e);
        }
    }

    public List<String> getAllOrdinateurs() {
        String query = "SELECT * FROM ordinateur";
        List<String> ordinateurs = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String ordinateur = "Processeur: " + resultSet.getString("processeur") +
                        ", Mémoire RAM: " + resultSet.getString("memoireRam") +
                        ", Taille Écran: " + resultSet.getString("taiileEcrant");
                ordinateurs.add(ordinateur);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des ordinateurs.", e);
        }

        return ordinateurs;
    }
}