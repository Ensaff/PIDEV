/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.Produit;
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
public class ServiceProduit implements IService<Produit> {
    private Connection cnx = DataSource.getInstance().getCnx();
    
    @Override
    public void ajouter(Produit p) {
        try {
            String req = "INSERT INTO Produit(nom, prix,idCategorie) VALUES (?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setFloat(2, p.getPrix());
            pst.setInt(3, p.getIdCategorie());
            pst.executeUpdate();
            System.out.println("Produit ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void modifier(Produit p) {
        try {
            String req = "UPDATE Produit SET nom=?, prix=? ,idCategorie=? WHERE idProduit=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(4, p.getIdProduit());
            pst.setString(1, p.getNom());
            pst.setFloat(2, p.getPrix());
            pst.setInt(3, p.getIdCategorie());
            pst.executeUpdate();
            System.out.println("Produit modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void supprimer(Produit p) {
        try {
            String req = "DELETE from Produit WHERE idProduit=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getIdProduit());
            pst.executeUpdate();
            System.out.println("Produit supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public List<Produit> afficher() {
        List<Produit> list = new ArrayList<>();
        
        String req = "SELECT * FROM Produit";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Produit(rs.getInt("idProduit"), rs.getString("nom"), rs.getFloat("prix"),rs.getInt ("IdCategorie")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    }
}
