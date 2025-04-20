package data;

import Interface.clientRepository;
import com.google.gson.*;
import java.io.*;
import java.util.*;

public class ClientJsonRepository implements  clientRepository {
    private final String fileName;
    private final Gson gson;

    public ClientJsonRepository(String fileName) {
        this.fileName = fileName;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void save(client client) {
        List<client> clients = load();
        clients.add(client);
        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(clients, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ajouterClient(client client) {

    }

    @Override
    public void modifierClient(client client) {

    }

    @Override
    public client findClientById(int id) {
        return null;
    }

    @Override
    public List<client> getAllClients() {
        return List.of();
    }

    @Override
    public List<Client> load() {
        try (Reader reader = new FileReader(fileName)) {
            return Arrays.asList(gson.fromJson(reader, Client[].class));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void save(client client1) {

    }
}