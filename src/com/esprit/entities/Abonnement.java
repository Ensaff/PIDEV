/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.sql.Date;


/**
 *
 * @author Ensaf^^
 */
public class Abonnement {
   private int idAbonnement;
   private String type;
   private Date dateDebut ;
   private Date dateFin ;
   private Float prix ;
   private int idAdherant ;

    public Abonnement(int id, String type, Date dateDebut, Date dateFin, Float prix, int idAdherant) {
        this.idAbonnement = id;
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
        this.idAdherant = idAdherant;
    }

    public Abonnement(String type, Date dateDebut, Date dateFin, Float prix, int idAdherant) {
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
        this.idAdherant = idAdherant;
    }

    public int getIdAbonnement() {
        return idAbonnement;
    }

    public String getType() {
        return type;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public Float getPrix() {
        return prix;
    }

    public int getIdAdherant() {
        return idAdherant;
    }

    public void setIdAbonnement(int id) {
        this.idAbonnement = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public void setIdAdherant(int idAdherant) {
        this.idAdherant = idAdherant;
    }

    @Override
    public String toString() {
        return "Abonnement{" + "id=" + idAbonnement + ", type=" + type + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", prix=" + prix + ", idAdherant=" + idAdherant + '}';
    }

 

    
}
