package repository;

import domain.Angajat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import static java.sql.DriverManager.*;

public class AngajatDbRepository implements Repository<Long, Angajat> {
    private String url;
    private String username;
    private String password;

    public AngajatDbRepository(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public Angajat findOne(Long aLong){
        Angajat rez = null;
        try (Connection connection = getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from angajat");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String post = resultSet.getString("post");
                double salariu = resultSet.getDouble("salariu");

                Angajat angajat = new Angajat(nume, prenume, post, salariu);
                angajat.setId(id);
                if(Objects.equals(aLong, id)){
                    rez = angajat;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rez;
    }

    public Angajat getOne(String t) {
        Angajat rez = null;
        try (Connection connection = getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from angajat");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String post = resultSet.getString("post");
                double salariu = resultSet.getDouble("salariu");

                Angajat angajat = new Angajat(nume,prenume,post,salariu);
                angajat.setId(id);
                if(Objects.equals(nume,t)){
                    rez = angajat;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rez;
    }

    @Override
    public Iterable<Angajat> findAll() {
        Set<Angajat> angajati = new HashSet<>();
        try (Connection connection = getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from angajat");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String post = resultSet.getString("post");
                double salariu = resultSet.getDouble("salariu");
                Angajat angajat = new Angajat(id,nume,prenume,post,salariu);
                angajat.setId(id);
                angajati.add(angajat);
            }
            return angajati;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return angajati;
    }

    @Override
    public Angajat save(Angajat entity) {
        return null;
    }

    @Override
    public Angajat delete(Long aLong) {
        return null;
    }

    @Override
    public Angajat update(Angajat entity) {
        return null;
    }
}
