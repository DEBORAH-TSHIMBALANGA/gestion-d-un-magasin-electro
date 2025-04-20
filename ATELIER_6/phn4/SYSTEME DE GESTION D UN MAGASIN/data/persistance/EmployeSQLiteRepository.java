package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeSQLiteRepository {
    private final String databaseUrl;

    public EmployeRepository(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public void addEmploye(String nom, String email, String role) {
        String query = "INSERT INTO employe (nom, email, role) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nom);
            statement.setString(2, email);
            statement.setString(3, role);
            statement.executeUpdate();

            System.out.println("Employé ajouté : " + nom);

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'ajout de l'employé.", e);
        }
    }

    public List<String> getAllEmployes() {
        String query = "SELECT * FROM employe";
        List<String> employes = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String employe = "ID: " + resultSet.getInt("idEmploye") +
                        ", Nom: " + resultSet.getString("nom") +
                        ", Email: " + resultSet.getString("email") +
                        ", Role: " + resultSet.getString("role");
                employes.add(employe);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des employés.", e);
        }

        return employes;
    }

    // Méthode pour supprimer ou modifier un employé peut être ajoutée ici
}