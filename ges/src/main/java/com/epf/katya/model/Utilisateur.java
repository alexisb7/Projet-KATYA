package com.epf.katya.model;

import java.time.LocalDate;

public class Utilisateur {
    private String id_utilisateur;
    private String email;
    private String mdp;
    private String nom_utilisateur;
    private String role;
    private LocalDate date_entree;

    public Utilisateur(){};

    public Utilisateur(String id_utilisateur, String email, String mdp, String nom_utilisateur, String role, LocalDate date_entree) {
        this.id_utilisateur = id_utilisateur;
        this.email = email;
        this.mdp = mdp;
        this.nom_utilisateur = nom_utilisateur;
        this.role = role;
        this.date_entree = date_entree;
    }

    @Override
    public String toString() {
        return "Utilisateur [date_entree=" + date_entree + ", email=" + email + ", id_utilisateur=" + id_utilisateur
                + ", mdp=" + mdp + ", nom_utilisateur=" + nom_utilisateur + ", role=" + role + "]";
    }

    public void setId_utilisateur(String id_utilisateur) {
        this.id_utilisateur = id_utilisateur;   
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDate_entree(LocalDate date_entree) {
        this.date_entree = date_entree;
    }

    public String getId_utilisateur() {
        return id_utilisateur;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public String getRole() {
        return role;
    }

    public LocalDate getDate_entree() {
        return date_entree;
    }

    
}

    