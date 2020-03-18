package com.example.test.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class RandonnneEtAssoModele {
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
        @SerializedName("nom_asso")
        @Expose
        private String nom_asso;
        @SerializedName("telephone_asso")
        @Expose
        private String telephone_asso;


        public RandonnneEtAssoModele(String no_randonnee, String date, String lieu, int nombreMini, String dateMaxRep, String nom_asso, String telephone_asso) {
            this.no_randonnee = no_randonnee;
            this.date = date;
            this.lieu = lieu;
            this.nombreMini = nombreMini;
            this.dateMaxRep = dateMaxRep;
            this.nom_asso = nom_asso;
            this.telephone_asso = telephone_asso;
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

        public int getNombreMini() {
            return nombreMini;
        }

        public void setNombreMini(int nombreMini) {
            this.nombreMini = nombreMini;
        }

        public String getDateMaxRep() {
            return dateMaxRep;
        }

        public void setDateMaxRep(String dateMaxRep) {
            this.dateMaxRep = dateMaxRep;
        }

        public String getNom_asso() {
            return nom_asso;
        }

        public void setNom_asso(String nom_asso) {
            this.nom_asso = nom_asso;
        }

        public String getTelephone_asso() {
            return telephone_asso;
        }

        public void setTelephone_asso(String telephone_asso) {
            this.telephone_asso = telephone_asso;
        }
    }

