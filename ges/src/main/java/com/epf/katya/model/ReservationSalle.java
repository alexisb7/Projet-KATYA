package com.epf.katya.model;

import java.time.LocalDate;


public class ReservationSalle {
    private int id_reservation_salle;
    private String numero_salle;
    private String id_utilisateur;
    private int etat_validation;
    private LocalDate date_debut;
    private LocalDate date_fin; 
    private String id_utilisateur_validation;

    public ReservationSalle(){}
    
    public ReservationSalle(int id_reservation_salle, String numero_salle, String id_utilisateur,
            int etat_validation, LocalDate date_debut, LocalDate date_fin, String id_utilisateur_validation) {
        this.id_reservation_salle = id_reservation_salle;
        this.numero_salle = numero_salle;
        this.id_utilisateur = id_utilisateur;
        this.etat_validation = etat_validation;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id_utilisateur_validation = id_utilisateur_validation;
    }

    @Override
    public String toString() {
        return "ReservationSalle [date_debut=" + date_debut + ", date_fin=" + date_fin + ", etat_validation="
                + etat_validation + ", id_reservation_salle=" + id_reservation_salle + ", id_utilisateur="
                + id_utilisateur + ", id_utilisateur_validation=" + id_utilisateur_validation
                + ", id_utnumero_sallilisateur=" + numero_salle + "]";
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

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public String getId_utilisateur_validation() {
        return id_utilisateur_validation;
    }

    public void setId_reservation_salle(int id_reservation_salle) {
        this.id_reservation_salle = id_reservation_salle;
    }

    public void setId_numero_salle(String numero_salle) {
        this.numero_salle = numero_salle;
    }

    public void setId_utilisateur(String id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setEtat_validation(int etat_validation) {
        this.etat_validation = etat_validation;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public void setId_utilisateur_validation(String id_utilisateur_validation) {
        this.id_utilisateur_validation = id_utilisateur_validation;
    }
   
}
