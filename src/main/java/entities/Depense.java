package entities;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DatabaseConnection;

public class Depense {
    private Float montant;
    private int idPrevision;

    public Depense(Float montant,int idPrevision){
        this.montant=montant;
        this.idPrevision=idPrevision;

    }

    public Float getMontant(){
        return montant;
    }

    public int getIdPrevision(){
        return idPrevision;
    }

    public void setMontant(Float montant){
        this.montant=montant;
    }

    public boolean insertDepense(Depense u) {
        
        if (u.getMontant() <= 0) {
            System.err.println("Erreur: Montant ou ID prévision invalide");
            return false;
        }

        
        String query = "INSERT INTO depense (montant, id_prevision) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setBigDecimal(1, BigDecimal.valueOf(u.getMontant())); 
            statement.setInt(2, u.getIdPrevision());

            int rowsAffected = statement.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Insertion réussie");
                return true;
            } else {
                System.out.println("Aucune ligne affectée");
                return false;
            }
            
        } catch (SQLException e) {
           
            System.err.println("Erreur SQL lors de l'insertion:");
            System.err.println("Message: " + e.getMessage());
            System.err.println("Code: " + e.getErrorCode());
            System.err.println("État SQL: " + e.getSQLState());
            
            
            if (e.getSQLState().equals("23000")) { 
                System.err.println("Erreur: La prévision spécifiée n'existe pas");
            }
            
            return false;
        }
    }

    public boolean updateDepeense(){

        return true;

    }



    
}


