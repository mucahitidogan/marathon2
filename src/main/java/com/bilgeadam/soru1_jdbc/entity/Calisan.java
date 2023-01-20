package com.bilgeadam.soru1_jdbc.entity;

public class Calisan {
    private int id;
    private String calisanAdi;
    private int calisanYasi;
    private int calisanMaasi;
    private String calisanDepartmani;
    private Sirket calisanSirketi;

    public Calisan(int id, String calisanAdi, int calisanYasi, int calisanMaasi, String calisanDepartmani, Sirket calisanSirketi) {
        this.id = id;
        this.calisanAdi = calisanAdi;
        this.calisanYasi = calisanYasi;
        this.calisanMaasi = calisanMaasi;
        this.calisanDepartmani = calisanDepartmani;
        this.calisanSirketi = calisanSirketi;
    }

    public Calisan(String calisanAdi, int calisanYasi, int calisanMaasi, String calisanDepartmani, Sirket calisanSirketi) {
        this.calisanAdi = calisanAdi;
        this.calisanYasi = calisanYasi;
        this.calisanMaasi = calisanMaasi;
        this.calisanDepartmani = calisanDepartmani;
        this.calisanSirketi = calisanSirketi;
    }

    public Calisan(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalisanAdi() {
        return calisanAdi;
    }

    public void setCalisanAdi(String calisanAdi) {
        this.calisanAdi = calisanAdi;
    }

    public int getCalisanYasi() {
        return calisanYasi;
    }

    public void setCalisanYasi(int calisanYasi) {
        this.calisanYasi = calisanYasi;
    }

    public int getCalisanMaasi() {
        return calisanMaasi;
    }

    public void setCalisanMaasi(int calisanMaasi) {
        this.calisanMaasi = calisanMaasi;
    }

    public String getCalisanDepartmani() {
        return calisanDepartmani;
    }

    public void setCalisanDepartmani(String calisanDepartmani) {
        this.calisanDepartmani = calisanDepartmani;
    }

    public Sirket getCalisanSirketi() {
        return calisanSirketi;
    }

    public void setCalisanSirketi(Sirket calisanSirketi) {
        this.calisanSirketi = calisanSirketi;
    }

    @Override
    public String toString() {
        return "Calisan{" +
                "id=" + id +
                ", calisanAdi='" + calisanAdi + '\'' +
                ", calisanYasi=" + calisanYasi +
                ", calisanMaasi=" + calisanMaasi +
                ", calisanDepartmani='" + calisanDepartmani + '\'' +
                ", calisanSirketi=" + calisanSirketi +
                '}';
    }
}
