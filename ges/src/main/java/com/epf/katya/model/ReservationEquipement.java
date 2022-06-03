package com.epf.katya.model;

import java.time.LocalDate;

public class ReservationEquipement {

    private int id_reservation_equipement;
    private int id_utilisateur;
    private int id_utilisateur_validation;
    private int id_equipement;
    private LocalDate date_debut;
    private LocalDate date_fin;
    private int etat_validation;

    public ReservationEquipement(int id_reservation_equipement, int id_utilisateur, int id_utilisateur_validation, int id_equipement, LocalDate date_debut, LocalDate date_fin, int etat_validation){

        this.id_reservation_equipement = id_reservation_equipement;
        this.id_utilisateur = id_utilisateur; 
        this.id_utilisateur_validation = id_utilisateur_validation;
        this.id_equipement = id_equipement;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.etat_validation = etat_validation;
    }

    public int getId_reservation_equipement() {
        return id_reservation_equipement;
    }

    public void setId_reservation_equipement(int id_reservation_equipement) {
        this.id_reservation_equipement = id_reservation_equipement;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public int getId_utilisateur_validation() {
        return id_utilisateur_validation;
    }

    public void setId_utilisateur_validation(int id_utilisateur_validation) {
        this.id_utilisateur_validation = id_utilisateur_validation;
    }

    public int getId_equipement() {
        return id_equipement;
    }

    public void setId_equipement(int id_equipement) {
        this.id_equipement = id_equipement;
    }

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public int getEtat_validation() {
        return etat_validation;
    }

    public void setEtat_validation(int etat_validation) {
        this.etat_validation = etat_validation;
    }

    @Override
    public String toString() {
        return "ReservationEquipement [date_debut=" + date_debut + ", date_fin=" + date_fin + ", etat_validation="
                + etat_validation + ", id_equipement=" + id_equipement + ", id_reservation_equipement="
                + id_reservation_equipement + ", id_utilisateur=" + id_utilisateur + ", id_utilisateur_validation="
                + id_utilisateur_validation + "]";
    }

    
}
