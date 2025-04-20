package data;

import Interface.commandeRepository;
import com.google.gson.*;

import java.io.*;
import java.util.*;

public class commandeJsonRepository implements commandeRepository {
    private final String fileName;
    private final Gson gson;

    public commandeJsonRepository(String fileName) {
        this.fileName = fileName;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void ajouterCommande(commande commande) {

    }

    @Override
    public void modifierCommande(commande commande) {

    }

    @Override
    public void save(commande commande) {
        List<commande> commandes = load();
        commandes.add(commande);
        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(commandes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<commande> load() {
        try (Reader reader = new FileReader(fileName)) {
            return Arrays.asList(gson.fromJson(reader, commande[].class));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void ajouterCommande(commande commande) {

    }

    @Override
    public void modifierCommande(commande commande) {

    }

    @Override
    public commande findCommandeById(int id) {
        return null;
    }

    @Override
    public List<commande> getAllCommandes() {
        return List.of();
    }
}