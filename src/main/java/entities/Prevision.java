package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;

public class Prevision {
    private String libelle;
    private Float montant;
    private int idPrevision;

    public Prevision(String libelle,Float montant){
        this.libelle=libelle;
        this.montant=montant;
    }
    public Prevision(){

    }

    public String getLibelle(){
        return libelle;
    }
    public Float getMontant(){
        return montant;
    }

    public void setLibelle(String libelle){
        this.libelle=libelle;
    }

    public void setMontant(Float montant){
        this.montant=montant;
    }
    public int getIdPrevision(){
        return idPrevision;
    }

    public void setIdPrevision(int idPrevision){
        this.idPrevision = idPrevision;
    }
    
    
    public boolean insertPrevision(Prevision p){
        String query = "INSERT INTO prevision (libelle, montant) values (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, p.libelle);
            statement.setFloat(2, p.montant);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0){
                return true;
            }
            else{
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Prevision> getAllPrevisions() {
        List<Prevision> Previsions = new ArrayList<>();
        String query = "SELECT id, libelle FROM prevision";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Prevision Prevision = new Prevision();
                Prevision.setIdPrevision(resultSet.getInt("id"));
                Prevision.setLibelle(resultSet.getString("libelle"));
                Previsions.add(Prevision);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Previsions;
    }

    

}
