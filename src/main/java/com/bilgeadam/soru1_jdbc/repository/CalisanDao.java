package com.bilgeadam.soru1_jdbc.repository;

import com.bilgeadam.soru1_jdbc.entity.Calisan;
import com.bilgeadam.soru1_jdbc.entity.Sirket;
import com.bilgeadam.soru1_jdbc.service.ICrud;
import com.bilgeadam.soru1_jdbc.utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalisanDao implements ICrud<Calisan> {
    DB db = new DB();
    List<Calisan> list = new ArrayList<>();
    Calisan calisan;
    @Override
    public void getAll() {
        try{
            String sql = "SELECT c.id, c.calisanAdi, c.calisanYasi, c.calisanMaasi, c.calisanDepartmani, s.sirketAdi, s.sirketFaaliyetAlani FROM calisan as c \n" +
                    "inner join sirket as s on c.sirket_id = s.id";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int calisanId = rs.getInt("id");
                String calisanAdi = rs. getString("calisanAdi");
                int calisanYasi = rs.getInt("calisanYasi");
                int calisanMaasi = rs.getInt("calisanMaasi");
                String calisanDepartmani = rs.getString("calisanDepartmani");
                String sirketAdi = rs.getString("sirketAdi");
                String sirketFaaliyetAlani = rs.getString("sirketFaaliyetAlani");

                calisan = new Calisan(calisanId,calisanAdi,calisanYasi,calisanMaasi,calisanDepartmani,new Sirket(sirketAdi,sirketFaaliyetAlani));
                list.add(calisan);
            }
            if (list.isEmpty()){
                System.out.println("Liste Boş");
            }else {
                list.forEach(System.out::println);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void save(Calisan calisan) {
        try {
            String sql = "insert into calisan(calisanAdi, calisanYasi, calisanMaasi, calisanDepartmani, sirket_id) values(?,?,?,?,?)";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, calisan.getCalisanAdi());
            preparedStatement.setInt(2, calisan.getCalisanYasi());
            preparedStatement.setInt(3, calisan.getCalisanMaasi());
            preparedStatement.setString(4, calisan.getCalisanDepartmani());
            preparedStatement.setInt(5, calisan.getCalisanSirketi().getId());

            preparedStatement.executeUpdate();
            System.out.println("Çalışan eklendi!!!");
            getAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(Calisan calisan) {
        try {
            String sql = "update calisan set calisanAdi = ?,calisanYasi  = ?, calisanMaasi  = ?, calisanDepartmani  = ?, sirket_id  = ? where id = ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, calisan.getCalisanAdi());
            preparedStatement.setInt(2, calisan.getCalisanYasi());
            preparedStatement.setInt(3, calisan.getCalisanMaasi());
            preparedStatement.setString(4, calisan.getCalisanDepartmani());
            preparedStatement.setInt(5, calisan.getCalisanSirketi().getId());
            preparedStatement.setInt(6, calisan.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

            getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from calisan where id=?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            getAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
