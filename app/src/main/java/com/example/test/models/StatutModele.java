package com.example.test.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatutModele {
    @SerializedName("no_statut")
    @Expose
    private String no_statut;
    @SerializedName("libelle")
    @Expose
    private String libelle;

    public StatutModele(String no_statut, String libelle) {
        this.no_statut = no_statut;
        this.libelle = libelle;
    }

    public String getNo_statut() {
        return no_statut;
    }

    public void setNo_statut(String no_statut) {
        this.no_statut = no_statut;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
