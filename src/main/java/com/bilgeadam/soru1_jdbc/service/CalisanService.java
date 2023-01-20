package com.bilgeadam.soru1_jdbc.service;

import com.bilgeadam.soru1_jdbc.entity.Calisan;
import com.bilgeadam.soru1_jdbc.entity.Sirket;
import com.bilgeadam.soru1_jdbc.repository.CalisanDao;
import com.bilgeadam.soru1_jdbc.utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CalisanService {

    public static void main(String[] args) {

        //getAll();
        //save();
        //update();
        //delete(1);

    }

    static CalisanDao calisanDao = new CalisanDao();
    public static void getAll() {
        try {
            calisanDao.getAll();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        Sirket sirket1 = new Sirket(2);
        Calisan calisan1 = new Calisan("Çalışan4",32,25000,"Departman4",sirket1);
        try {
            calisanDao.save(calisan1);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update() {
        Sirket sirket1 = new Sirket(2);
        Calisan calisan1 = new Calisan(1,"Çalışan3",48,47000,"Departman2",sirket1);
        try {
            calisanDao.update(calisan1);
            System.out.println("Çalışan güncellendi!!!");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        try {
            calisanDao.delete(id);
            System.out.println("Çalışan silindi!!!");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
