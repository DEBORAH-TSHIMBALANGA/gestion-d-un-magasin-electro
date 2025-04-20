package Interface;

import data.employe;

import java.util.List;

public interface employeRepository {

        void ajouterEmploye(employe employe);
        void modifierEmploye(employe employe);
        employe findEmployeById(int id);
        List<employe> getAllEmployes();

    List<employe> load();

    void save(employe employe1);
}

