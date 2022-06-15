package com.epf.katya.model;

import java.time.LocalDate;

public class Equipement {

    private int id_equipement;
    private String nom_equipement;
    private String zone_stockage;
    private String etat;
    private int disponibilite_equipement;
    private LocalDate date_acquisition;
    private String description;
    private String lien_documentation;

    public Equipement(int id_equipement, String nom_equipement, String zone_stockage, String etat, int disponibilite_equipement, LocalDate date_acquisition, String description, String lien_documentation) {
        this.id_equipement = id_equipement;
        this.nom_equipement = nom_equipement;
        this.zone_stockage = zone_stockage;
        this.etat = etat;
        this.disponibilite_equipement = disponibilite_equipement;
        this.date_acquisition = date_acquisition;
        this.description = description;
        this.lien_documentation = lien_documentation;
    }

    public Equipement(int idEquipement, String parameter, String string, String parameter2, int parseInt2, LocalDate parse,
            String lien_documentation) {
    }

    public int getId_equipement() {
        return id_equipement;
    }

    public void setId_equipement(int id_equipement) {
        this.id_equipement = id_equipement;
    }

    public String getNom_equipement() {
        return nom_equipement;
    }

    public void setNom_equipement(String nom_equipement) {
        this.nom_equipement = nom_equipement;
    }

    public String getZone_stockage() {
        return zone_stockage;
    }

    public void setZone_stockage(String zone_stockage) {
        this.zone_stockage = zone_stockage;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getDisponibilite_equipement() {
        return disponibilite_equipement;
    }

    public void setDisponibilite_equipement(int disponibilite_equipement) {
        this.disponibilite_equipement = disponibilite_equipement;
    }

    public LocalDate getDate_acquisition() {
        return date_acquisition;
    }

    public void setDate_acquisition(LocalDate date_acquisition) {
        this.date_acquisition = date_acquisition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLien_documentation() {
        return lien_documentation;
    }

    public void setLien_documentation(String lien_documentation) {
        this.lien_documentation = lien_documentation;
    }

    @Override
    public String toString() {
        return "Equipement [date_acquisition=" + date_acquisition + ", description=" + description
                + ", disponibilite_equipement=" + disponibilite_equipement + ", etat=" + etat + ", lien_documentation="
                + lien_documentation + ", id_equipement=" + id_equipement + ", nom_equipement=" + nom_equipement
                + ", zone_stockage=" + zone_stockage + "]";
    }

    
}
