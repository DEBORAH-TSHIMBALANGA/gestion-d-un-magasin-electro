package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandeSQLiteRepository {
    private final String databaseUrl;

    public CommandeRepository(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public void addCommande(String produitCommande, String dateCommande) {
        String query = "INSERT INTO Commandes (produitCommande, dateCommande) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, produitCommande);
            statement.setString(2, dateCommande);
            statement.executeUpdate();

            System.out.println("Commande ajoutée : " + produitCommande);

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'ajout de la commande.", e);
        }
    }

    public List<String> getAllCommandes() {
        String query = "SELECT * FROM Commandes";
        List<String> commandes = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String commande = "ID: " + resultSet.getInt("idCommande") +
                        ", Produit: " + resultSet.getString("produitCommande") +
                        ", Date: " + resultSet.getString("dateCommande");
                commandes.add(commande);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des commandes.", e);
        }

        return commandes;
    }
}