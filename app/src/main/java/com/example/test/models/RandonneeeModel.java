package com.example.test.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RandonneeeModel {
    @SerializedName("no_randonnee")
    @Expose
    private String no_randonnee;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("lieu")
    @Expose
    private String lieu;
    @SerializedName("nombreMini")
    @Expose
    private int nombreMini;
    @SerializedName("dateMaxRep")
    @Expose
    private String dateMaxRep;

    public RandonneeeModel(String no_randonnee, String date, String lieu, int nombreMini, String dateMaxRep) {
        this.no_randonnee = no_randonnee;
        this.date = date;
        this.lieu = lieu;
        this.nombreMini = nombreMini;
        this.dateMaxRep = dateMaxRep;
    }

    public String getNo_randonnee() {
        return no_randonnee;
    }

    public void setNo_randonnee(String no_randonnee) {
        this.no_randonnee = no_randonnee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getNombremini() {
        return nombreMini;
    }

    public void setNombremini(int nombremini) {
        this.nombreMini = nombremini;
    }

    public String getDatemaxrep() {
        return dateMaxRep;
    }

    public void setDatemaxrep(String datemaxrep) {
        this.dateMaxRep = datemaxrep;
    }

}