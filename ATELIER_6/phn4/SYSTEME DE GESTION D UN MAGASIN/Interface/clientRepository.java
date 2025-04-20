package Interface;

import data.client;

import java.util.List;

public interface clientRepository {

    void save(Client client);

    void ajouterClient(client client);
        void modifierClient(client client);
        client findClientById(int id);
        List<client> getAllClients();

    List<client> load();

    void save(client client1);
}

