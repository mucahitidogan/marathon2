package com.bilgeadam.soru2_hibernate.util;

import com.bilgeadam.soru2_hibernate.entity.Musteri;
import com.bilgeadam.soru2_hibernate.entity.Siparis;
import com.bilgeadam.soru2_hibernate.entity.SiparisKalemi;
import com.bilgeadam.soru2_hibernate.entity.Urun;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null){
            try{
                Configuration configuration = new Configuration();
                //Bu aslında hibernate.cfg.xml'deki mapping yerine kullanılıyor.
                //Orada ya da burada kullanarak diğerini kullanmıyoruz.
                configuration.addAnnotatedClass(Musteri.class);
                configuration.addAnnotatedClass(Siparis.class);
                configuration.addAnnotatedClass(SiparisKalemi.class);
                configuration.addAnnotatedClass(Urun.class);
                sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
