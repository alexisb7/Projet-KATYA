package com.epf.katya.model;

import java.time.LocalDate;
import java.time.LocalTime;


public class ReservationSalle {
    private int id_reservation_salle;
    private String numero_salle;
    private String id_utilisateur;
    private int etat_validation;
    private LocalDate date;
    private LocalTime heure_debut;
    private LocalTime heure_fin; 
    private String id_utilisateur_validation;

    public ReservationSalle(){}
    
    public ReservationSalle(int id_reservation_salle, String numero_salle, String id_utilisateur,
            int etat_validation, LocalDate date, LocalTime heure_debut, LocalTime heure_fin, String id_utilisateur_validation) {
        this.id_reservation_salle = id_reservation_salle;
        this.numero_salle = numero_salle;
        this.id_utilisateur = id_utilisateur;
        this.etat_validation = etat_validation;
        this.date = date;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.id_utilisateur_validation = id_utilisateur_validation;
    }

    @Override
    public String toString() {
        return "ReservationSalle [date=" + date + ", heure_fin=" + heure_fin + ", heure_debut=" + heure_debut + ", etat_validation="
                + etat_validation + ", id_reservation_salle=" + id_reservation_salle + ", id_utilisateur="
                + id_utilisateur + ", id_utilisateur_validation=" + id_utilisateur_validation
                + ", numero_salle=" + numero_salle + "]";
    }

    public int getId_reservation_salle() {
        return id_reservation_salle;
    }

    public String getNumero_salle() {
        return numero_salle;
    }

    public String getId_utilisateur() {
        return id_utilisateur;
    }

    public int getEtat_validation() {
        return etat_validation;
    }


    public String getId_utilisateur_validation() {
        return id_utilisateur_validation;
    }

    public void setId_reservation_salle(int id_reservation_salle) {
        this.id_reservation_salle = id_reservation_salle;
    }

    public void setId_utilisateur(String id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setEtat_validation(int etat_validation) {
        this.etat_validation = etat_validation;
    }

    

    public void setNumero_salle(String numero_salle) {
        this.numero_salle = numero_salle;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(LocalTime heure_debut) {
        this.heure_debut = heure_debut;
    }

    public LocalTime getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(LocalTime heure_fin) {
        this.heure_fin = heure_fin;
    }

    public void setId_utilisateur_validation(String id_utilisateur_validation) {
        this.id_utilisateur_validation = id_utilisateur_validation;
    }
   
}
