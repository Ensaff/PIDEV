/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.tests;

import com.esprit.entities.Abonnement;
import com.esprit.entities.Categorie;
import com.esprit.entities.Produit;
import com.esprit.services.ServiceAbonnement;
import com.esprit.services.ServiceCategorie;
import com.esprit.services.ServiceProduit;

/**
 *
 * @author Ensaf^^
 */
public class MainProg {
    public static void main(String[] args) {

//creation instance Abonnement        
Abonnement A1 = new Abonnement(" Blue Pass-Sport",java.sql.Date.valueOf("2023-05-15"),java.sql.Date.valueOf("2023-08-15"),350f ,2);
 ServiceAbonnement sa = new ServiceAbonnement();
  // sa.ajouter(A1);
 // System.out.println(sa.afficher()); 
  //sa.modifier(new Abonnement(8,"Yelow Pass-Sport",java.sql.Date.valueOf("2023-05-16"),java.sql.Date.valueOf("2023-09-16"),350f ,6)); //la deuxieme date est incorreste??
 //System.out.println(sa.afficher()); 
 // sa.supprimer(new Abonnement(8,"Yelow Pass-Sport",java.sql.Date.valueOf("2023-05-16"),java.sql.Date.valueOf("2023-09-16"),350f ,6));
 // System.out.println(sa.afficher()); 
         
       ServiceCategorie sc = new ServiceCategorie();
        //sc.ajouter(new Categorie("accessoires"));
       //System.out.println(sc.afficher());
        //sc.modifier(new Categorie(3,"proteines"));
      //  System.out.println(sc.afficher());
      // sc.supprimer(new Categorie(3,"proteines"));
      // System.out.println(sc.afficher());
   
       
       
       ServiceProduit sp = new ServiceProduit();
      // sp.ajouter(new Produit("Gant de box",100f,2));
     // System.out.println(sp.afficher());
      // sp.modifier(new Produit(5,"cap",50f,6));
      // System.out.println(sp.afficher());
  // sp.supprimer(new Produit(5,"cap",50f,6));
        
    }
}

