package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelephoneSQLiteRepository {
    private final String databaseUrl;

    public TelephoneRepository(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public void addTelephone(String marque, String systeme, int memoire) {
        String query = "INSERT INTO telephone (marque, systeme, memoire) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, marque);
            statement.setString(2, systeme);
            statement.setInt(3, memoire);
            statement.executeUpdate();

            System.out.println("Téléphone ajouté avec succès : " + marque);

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'ajout du téléphone.", e);
        }
    }

    public List<String> getAllTelephones() {
        String query = "SELECT * FROM telephone";
        List<String> telephones = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String telephone = "Marque: " + resultSet.getString("marque") +
                        ", Système: " + resultSet.getString("systeme") +
                        ", Mémoire: " + resultSet.getInt("memoire");
                telephones.add(telephone);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des téléphones.", e);
        }

        return telephones;
    }
}