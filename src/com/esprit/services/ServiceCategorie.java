/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.Categorie;
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
public class ServiceCategorie implements IService<Categorie> {
    private Connection cnx = DataSource.getInstance().getCnx();
    
    @Override
    public void ajouter(Categorie c) {
        try {
            String req = "INSERT INTO Categorie(nom) VALUES (?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, c.getNom());
            pst.executeUpdate();
            System.out.println("Categorie ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifier(Categorie c) {
        try {
            String req = "UPDATE Categorie SET nom=? WHERE idCategorie=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(2, c.getIdCategorie());
            pst.setString(1, c.getNom());
            pst.executeUpdate();
            System.out.println("Categorie modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void supprimer(Categorie c) {
        try {
            String req = "DELETE from Categorie WHERE idCategorie=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, c.getIdCategorie());
            pst.executeUpdate();
            System.out.println("Categorie supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public List<Categorie> afficher() {
        List<Categorie> list = new ArrayList<>();
        
        String req = "SELECT * FROM Categorie";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Categorie(rs.getInt("idCategorie"), rs.getString("nom")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    }
}
