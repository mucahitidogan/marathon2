package com.bilgeadam.soru2_hibernate.repository;

import com.bilgeadam.soru2_hibernate.entity.Siparis;
import com.bilgeadam.soru2_hibernate.service.ICrud;
import com.bilgeadam.soru2_hibernate.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class SiparisDao implements ICrud<Siparis> {
    @Override
    public void getAll() {
        List<Object[]> siparisList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "SELECT s.id as siparisId, m.id as musteriId, m.adi, m.soyadi, u.urunAdi, u.urunFiyati, sk.urunAdedi FROM siparis as s inner join musteri as m on m.id = s.musteri_id\n" +
                    "inner join siparis_sipariskalemi ssk on ssk.Siparis_id = s.id\n" +
                    "inner join sipariskalemi as sk on sk.id = ssk.siparisKalemi_id\n" +
                    "inner join urun u on u.id = sk.urun_id";
            siparisList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : siparisList) {
                System.out.println("Sipariş ID: " + item[0] + " --"
                        + " Müşteri ID: " + item[1] + " --"
                        + " Müşteri: " + item[2] + " " + item[3] + " --"
                        + " Ürün Adı: " + item[4] + " --"
                        + " Ürün Fiyatı: " + item[5] + " --"
                        + " Sipariş edilen ürün sayısı: " + item[6]
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void save(Siparis siparis) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.save(siparis);
            session.getTransaction().commit();
            System.out.println("Sipariş verildi!!!");
            session.close();
            getAll();
        }catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Siparis siparis) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(siparis);
            session.getTransaction().commit();
            session.close();
            getAll();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Session session = null;
        Siparis siparis = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            siparis = session.load(Siparis.class, id);
            session.delete(siparis);
            session.getTransaction().commit();
            getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            session.getTransaction().rollback();
        }


    }

    public void soru2_A_getAllSiparisWithToplamFiyat() {
        List<Object[]> siparisList = null;
        int siparisId = 0;
        int toplamFiyat = 0;
        int sayac = 0;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "SELECT s.id as siparisId, m.adi, m.soyadi, m.id as musteriId, u.urunAdi, u.urunFiyati, sk.urunAdedi FROM siparis as s inner join musteri as m on m.id = s.musteri_id\n" +
                    "inner join siparis_sipariskalemi ssk on ssk.Siparis_id = s.id\n" +
                    "inner join sipariskalemi as sk on sk.id = ssk.siparisKalemi_id\n" +
                    "inner join urun u on u.id = sk.urun_id";
            siparisList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : siparisList) {
                if(siparisId != (int) item[0] && sayac !=0) {
                    System.out.println(" Sipariş Toplam: " + toplamFiyat + " TL.");
                }
                if(siparisId != (int) item[0])
                {
                    toplamFiyat = 0;
                    siparisId = (int) item[0];
                    System.out.println("Sipariş ID: " + item[0] + " --"
                            + " Müşteri: " + item[1] + " " + item[2] + " --"
                            + " Müşteri ID: " + item[3] + " --"

                    );
                }
                    System.out.println(" Ürün: " + item[4] + " --"
                            + " Fiyat: " + item[5] + " --"
                            + " Adet Sayısı: " + item[6]
                    );
                    toplamFiyat += (int) item[5];
                sayac++;
                if(sayac == siparisList.size()) {
                    System.out.println(" Sipariş Toplam: " + toplamFiyat + " TL.");
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void soru2_B_getAllMusteriWithToplamFiyat() {
        List<Object[]> siparisList = null;
        int musteriId = 0;
        int siparisId = 0;
        int toplamFiyat = 0;
        int sayac = 0;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "SELECT m.id as musteriId, m.adi, m.soyadi, s.id as siparisId, u.urunAdi, u.urunFiyati, sk.urunAdedi FROM siparis as s inner join musteri as m on m.id = s.musteri_id\n" +
                    "inner join siparis_sipariskalemi ssk on ssk.Siparis_id = s.id\n" +
                    "inner join sipariskalemi as sk on sk.id = ssk.siparisKalemi_id\n" +
                    "inner join urun u on u.id = sk.urun_id";
            siparisList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : siparisList) {
                if(musteriId != (int) item[0] && sayac !=0) {
                    System.out.println("Toplam Harcama: " + toplamFiyat + " TL.");
                }
                if(musteriId != (int) item[0])
                {
                    toplamFiyat = 0;
                    musteriId = (int) item[0];
                    System.out.println("Müşteri ID: " + item[0] + " --"
                            + " Müşteri Ad: " + item[1] + " --"
                            + " Müşteri Soyad: " + item[2]
                    );
                }
                if(siparisId != (int) item[3])
                {
                    siparisId = (int) item[3];
                    System.out.println("    Sipariş ID: " + item[3]);
                }
                System.out.println("        Ürün: " + item[4] + " --"
                        + " Fiyat: " + item[5] + " --"
                        + " Adet: " + item[6]
                );
                toplamFiyat = toplamFiyat + ((int) item[5] * (int) item[6]);
                sayac++;
                if(sayac == siparisList.size()) {
                    System.out.println("Toplam Harcama: " + toplamFiyat + " TL.\n");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public void soru2_C_getMusteriWithSiparisCount() {
        List<Object[]> siparisList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "SELECT m.id as musteriId, count(*) as toplamSiparis FROM siparis as s inner join musteri as m on m.id = s.musteri_id\n" +
                    "inner join siparis_sipariskalemi ssk on ssk.Siparis_id = s.id\n" +
                    "inner join sipariskalemi as sk on sk.id = ssk.siparisKalemi_id\n" +
                    "inner join urun u on u.id = sk.urun_id\n" +
                    "group by s.id";
            siparisList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : siparisList) {
                System.out.println("Müşteri ID: " + item[0] + " --"
                        + " Sipariş Sayısı: " + item[1]
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public void soru2_D_getMusteriWithSipariId() {
        List<Object[]> siparisList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "SELECT m.adi,m.soyadi, s.id FROM siparis as s inner join musteri as m on m.id = s.musteri_id\n" +
                    "inner join siparis_sipariskalemi ssk on ssk.Siparis_id = s.id\n" +
                    "inner join sipariskalemi as sk on sk.id = ssk.siparisKalemi_id\n" +
                    "inner join urun u on u.id = sk.urun_id";
            siparisList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : siparisList) {
                System.out.println("Müşteri Ad: " + item[0] + " --"
                        + " Müşteri Soyad: " + item[1] + " --"
                        + " Sipariş ID: " + item[2]
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
}
