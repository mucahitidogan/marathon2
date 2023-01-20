package com.bilgeadam.soru1_jdbc.entity;

public class Sirket {

    private int id;
    private String sirketAdi;
    private String sirketSahibi;
    private String sirketUnvani;
    private String sirketFaaliyetAlani;
    private int sirketKurulusYili;

    public Sirket(String sirketAdi, String sirketFaaliyetAlani) {
        this.sirketAdi = sirketAdi;
        this.sirketFaaliyetAlani = sirketFaaliyetAlani;
    }

    public Sirket(String sirketAdi) {
        this.sirketAdi = sirketAdi;
    }

    public Sirket(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSirketAdi() {
        return sirketAdi;
    }

    public void setSirketAdi(String sirketAdi) {
        this.sirketAdi = sirketAdi;
    }

    public String getSirketSahibi() {
        return sirketSahibi;
    }

    public void setSirketSahibi(String sirketSahibi) {
        this.sirketSahibi = sirketSahibi;
    }

    public String getSirketUnvani() {
        return sirketUnvani;
    }

    public void setSirketUnvani(String sirketUnvani) {
        this.sirketUnvani = sirketUnvani;
    }

    public String getSirketFaaliyetAlani() {
        return sirketFaaliyetAlani;
    }

    public void setSirketFaaliyetAlani(String sirketFaaliyetAlani) {
        this.sirketFaaliyetAlani = sirketFaaliyetAlani;
    }

    public int getSirketKurulusYili() {
        return sirketKurulusYili;
    }

    public void setSirketKurulusYili(int sirketKurulusYili) {
        this.sirketKurulusYili = sirketKurulusYili;
    }

    @Override
    public String toString() {
        return "Sirket{" +
                "id=" + id +
                ", sirketAdi='" + sirketAdi + '\'' +
                ", sirketSahibi='" + sirketSahibi + '\'' +
                ", sirketUnvani='" + sirketUnvani + '\'' +
                ", sirketFaaliyetAlani='" + sirketFaaliyetAlani + '\'' +
                ", sirketKurulusYili=" + sirketKurulusYili +
                '}';
    }
}
