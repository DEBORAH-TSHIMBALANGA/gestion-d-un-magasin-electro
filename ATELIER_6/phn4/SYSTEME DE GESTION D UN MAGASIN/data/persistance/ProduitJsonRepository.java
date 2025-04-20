package data.persistance;

import Interface.ProduitRepository;
import com.google.gson.*;
import data.Produit;


import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.*;

public class ProduitJsonRepository implements ProduitRepository {
    private final String fileName;
    private final Gson gson;

    public ProduitJsonRepository(String fileName) {
        this.fileName = fileName;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void save(Produit produit) {
        List<Produit> produits = load();
        produits.add(produit);
        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(produits, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Produit> load() {
        try (Reader reader = new FileReader(fileName)) {
            return Arrays.asList(gson.fromJson(reader, Produit[].class));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void ajouterProduit(Produit produit) {

    }

    @Override
    public void supprimerProduit(Produit produit) {

    }

    @Override
    public void modifierProduit(Produit produit) {

    }

    @Override
    public Produit findProduitById(int id) {
        return null;
    }

    @Override
    public List<Produit> getAllProduits() {
        return List.of();
    }
}

