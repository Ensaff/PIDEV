/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.Abonnement;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ensaf^^
 */
public class ServiceAbonnement implements IService<Abonnement> {
    
    private Connection cnx = DataSource.getInstance().getCnx();
    
    @Override
    public void ajouter(Abonnement A) {
        try {
            String req = "INSERT INTO Abonnement (type, dateDebut,dateFin,prix,idAdherant) VALUES (?,?,?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, A.getType());
            pst.setDate(2, A.getDateDebut());
            pst.setDate(3, A.getDateFin());
            pst.setFloat(4,A.getPrix());
            pst.setInt(5,A.getIdAdherant());
            pst.executeUpdate();
            System.out.println("Abonnement ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifier(Abonnement A) {
        try {
            String req = "UPDATE Abonnement SET type=?, dateDebut=?,dateFin=?,prix=?,idAdherant=? WHERE idAbonnement=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(6, A.getIdAbonnement());
            pst.setString(1, A.getType());
            pst.setDate(2, A.getDateDebut());
            pst.setDate(3, A.getDateDebut());
            pst.setFloat(4,A.getPrix());
            pst.setInt(5,A.getIdAdherant());
            pst.executeUpdate();
            System.out.println("Abonnement modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void supprimer(Abonnement A) {
        try {
            String req = "DELETE from Abonnement WHERE idAbonnement=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, A.getIdAbonnement());
            pst.executeUpdate();
            System.out.println("Abonnement supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public List<Abonnement> afficher() {
        List<Abonnement> list = new ArrayList<>();
        
        String req = "SELECT * FROM Abonnement";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
            list.add(new Abonnement(rs.getInt("idAbonnement"),rs.getString("type"),
                    rs.getDate("dateDebut")
                    ,rs.getDate("dateFin")
                    ,rs.getFloat("prix"),
                    rs.getInt("idAdherant")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    }
    
}
