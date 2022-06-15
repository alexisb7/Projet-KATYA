package com.epf.katya.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationEquipement {

    private int id_reservation_equipement;
    private String id_utilisateur;
    private String id_utilisateur_validation;
    private int id_equipement;
    private LocalDate date;
    private LocalTime heure_debut;
    private LocalTime heure_fin;
    private int etat_validation;

    public ReservationEquipement(){}

    public ReservationEquipement(int id_reservation_equipement, String id_utilisateur, String id_utilisateur_validation, int id_equipement, LocalDate date, LocalTime heure_debut, LocalTime heure_fin, int etat_validation){

        this.id_reservation_equipement = id_reservation_equipement;
        this.id_utilisateur = id_utilisateur; 
        this.id_utilisateur_validation = id_utilisateur_validation;
        this.id_equipement = id_equipement;
        this.date = date;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.etat_validation = etat_validation;
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

    public int getId_reservation_equipement() {
        return id_reservation_equipement;
    }

    public void setId_reservation_equipement(int id_reservation_equipement) {
        this.id_reservation_equipement = id_reservation_equipement;
    }

    public String getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(String id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getId_utilisateur_validation() {
        return id_utilisateur_validation;
    }

    public void setId_utilisateur_validation(String id_utilisateur_validation) {
        this.id_utilisateur_validation = id_utilisateur_validation;
    }

    public int getId_equipement() {
        return id_equipement;
    }

    public void setId_equipement(int id_equipement) {
        this.id_equipement = id_equipement;
    }

    public int getEtat_validation() {
        return etat_validation;
    }

    public void setEtat_validation(int etat_validation) {
        this.etat_validation = etat_validation;
    }

    @Override
    public String toString() {
        return "ReservationEquipement [date=" + date + ", heure_debut=" + heure_debut + ", heure_fin=" + heure_fin + ", etat_validation="
                + etat_validation + ", id_equipement=" + id_equipement + ", id_reservation_equipement="
                + id_reservation_equipement + ", id_utilisateur=" + id_utilisateur + ", id_utilisateur_validation="
                + id_utilisateur_validation + "]";
    }

    
}
