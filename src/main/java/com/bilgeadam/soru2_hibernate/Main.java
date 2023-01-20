package com.bilgeadam.soru2_hibernate;

import com.bilgeadam.soru2_hibernate.entity.Musteri;
import com.bilgeadam.soru2_hibernate.entity.Siparis;
import com.bilgeadam.soru2_hibernate.entity.SiparisKalemi;
import com.bilgeadam.soru2_hibernate.entity.Urun;
import com.bilgeadam.soru2_hibernate.repository.SiparisDao;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        //save();
        //getAll();
        //update();
        //delete(1);
        //soru2_A_getAllSiparisWithSumFiyat();
        //soru2_B_getAllMusteriWithToplamFiyat();
        //soru2_C_getMusteriWithSiparisCount();
        //soru2_D_getMusteriWithSipariId();

    }

    static SiparisDao siparisDao = new SiparisDao();
    public static void save() {
        Musteri m1 = new Musteri("Ali","Kaya");
        Musteri m2 = new Musteri("Veli","Özkan");

        Urun u1 = new Urun("Iphone 11",17000);
        Urun u2 = new Urun("Samsung S21",18000);
        Urun u3 = new Urun("LG LED TV",8500);
        Urun u4 = new Urun("Arçelik Süpürge",2500);

        SiparisKalemi sk1 = new SiparisKalemi(u1, 1);
        SiparisKalemi sk2 = new SiparisKalemi(u2, 2);
        Siparis s1 = new Siparis(m1, Arrays.asList(sk1,sk2));

        SiparisKalemi sk3 = new SiparisKalemi(u2, 2);
        SiparisKalemi sk4 = new SiparisKalemi(u3, 1);
        Siparis s2 = new Siparis(m2, Arrays.asList(sk1,sk4));

        SiparisKalemi sk5 = new SiparisKalemi(u4, 2);
        Siparis s3 = new Siparis(m1, Arrays.asList(sk5));

        Siparis s4 = new Siparis(m2, Arrays.asList(new SiparisKalemi(u1,1)));
        Siparis s5 = new Siparis(m2, Arrays.asList(new SiparisKalemi(u2,1)));
        try {
            siparisDao.save(s2);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAll() {
        try {
            siparisDao.getAll();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update() {
        Musteri m1 = new Musteri("Kahraman","Çelik");
        Urun u1 = new Urun("Beko Buzdolabı",13250);
        Siparis s1 = new Siparis(5,m1, Arrays.asList(new SiparisKalemi(u1,2)));
        try {
            siparisDao.update(s1);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void delete(int id) {
        try {
            siparisDao.delete(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void soru2_A_getAllSiparisWithSumFiyat() {
        try {
            siparisDao.soru2_A_getAllSiparisWithToplamFiyat();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void soru2_B_getAllMusteriWithToplamFiyat() {
        try {
            siparisDao.soru2_B_getAllMusteriWithToplamFiyat();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void soru2_C_getMusteriWithSiparisCount(){
        try {
            siparisDao.soru2_C_getMusteriWithSiparisCount();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void soru2_D_getMusteriWithSipariId(){
        try {
            siparisDao.soru2_D_getMusteriWithSipariId();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
