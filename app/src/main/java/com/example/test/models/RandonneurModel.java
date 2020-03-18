package com.example.test.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RandonneurModel {
    @SerializedName("no_randonneur")
    @Expose
    private String no_randonneur;
    @SerializedName("email_randonneur")
    @Expose
    private String email_randonneur;
    @SerializedName("motdepasse_randonneur")
    @Expose
    private String motdepasse_randonneur;
    @SerializedName("motdepass_randonneur")
    @Expose
    private String motdepass_randonneur;
    @SerializedName("nom_randonneur")
    @Expose
    private String nom_randonneur;
    @SerializedName("prenom_randonneur")
    @Expose
    private String prenom_randonneur;
    @SerializedName("adresse_randonneur")
    @Expose
    private String adresse_randonneur;

    public RandonneurModel(String no_randonneur, String email_randonneur, String motdepasse_randonneur, String motdepass_randonneur, String nom_randonneur, String prenom_randonneur, String adresse_randonneur) {
        this.no_randonneur = no_randonneur;
        this.email_randonneur = email_randonneur;
        this.motdepasse_randonneur = motdepasse_randonneur;
        this.motdepass_randonneur = motdepass_randonneur;
        this.nom_randonneur = nom_randonneur;
        this.prenom_randonneur = prenom_randonneur;
        this.adresse_randonneur = adresse_randonneur;
    }

    public String getNo_randonneur() {
        return no_randonneur;
    }

    public void setNo_randonneur(String no_randonneur) {
        this.no_randonneur = no_randonneur;
    }

    public String getEmail_randonneur() {
        return email_randonneur;
    }

    public void setEmail_randonneur(String email_randonneur) {
        this.email_randonneur = email_randonneur;
    }

    public String getMotdepasse_randonneur() {
        return motdepasse_randonneur;
    }

    public void setMotdepasse_randonneur(String motdepasse_randonneur) {
        this.motdepasse_randonneur = motdepasse_randonneur;
    }

    public String getMotdepass_randonneur() {
        return motdepass_randonneur;
    }

    public void setMotdepass_randonneur(String motdepass_randonneur) {
        this.motdepass_randonneur = motdepass_randonneur;
    }

    public String getNom_randonneur() {
        return nom_randonneur;
    }

    public void setNom_randonneur(String nom_randonneur) {
        this.nom_randonneur = nom_randonneur;
    }

    public String getPrenom_randonneur() {
        return prenom_randonneur;
    }

    public void setPrenom_randonneur(String prenom_randonneur) {
        this.prenom_randonneur = prenom_randonneur;
    }

    public String getAdresse_randonneur() {
        return adresse_randonneur;
    }

    public void setAdresse_randonneur(String adresse_randonneur) {
        this.adresse_randonneur = adresse_randonneur;
    }
}
