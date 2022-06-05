package com.epf.katya.model;

import java.time.LocalDate;

public class Salle {
    private String numero;
    private int etage;
    private int capacite;
    private String utilite;
    private int disponibilite_salle;
    private LocalDate date_acquisition_salle;

    public Salle(){}

    

    public Salle(String numero, int etage, int capacite, String utilite, int disponibilite_salle, LocalDate date_acquisition_salle) {
        this.numero = numero;
        this.etage = etage;
        this.capacite = capacite;
        this.utilite = utilite;
        this.disponibilite_salle = disponibilite_salle;
        this.date_acquisition_salle = date_acquisition_salle;
    }



    @Override
    public String toString() {
        return "Salle [capacite=" + capacite + ", date_acquisition_salle=" + date_acquisition_salle
                + ", disponibilite_salle=" + disponibilite_salle + ", etage=" + etage + ", numero=" + numero
                + ", utilite=" + utilite + "]";
    }



    public String getNumero() {
        return numero;
    }

    public int getEtage() {
        return etage;
    }

    public int getCapacite() {
        return capacite;
    }

    public String getUtilite() {
        return utilite;
    }

    public int getDisponibilite_salle() {
        return disponibilite_salle;
    }

    public LocalDate getDate_acquisition_salle() {
        return date_acquisition_salle;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setUtilite(String utilite) {
        this.utilite = utilite;
    }

    public void setDisponibilite_salle(int disponibilite_salle) {
        this.disponibilite_salle = disponibilite_salle;
    }

    public void setDate_acquisition_salle(LocalDate date_acquisition_salle) {
        this.date_acquisition_salle = date_acquisition_salle;
    };

    
}
