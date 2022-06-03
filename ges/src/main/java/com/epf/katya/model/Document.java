package com.epf.katya.model;

public class Document {
    
    private int id_document;
    private String lien;

    public Document(int id_document, String lien) {
        this.id_document = id_document;
        this.lien = lien;
    }

    public int getId_document() {
        return id_document;
    }

    public void setId_document(int id_document) {
        this.id_document = id_document;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    @Override
    public String toString() {
        return "Document [id_document=" + id_document + ", lien=" + lien + "]";
    }

    

}
