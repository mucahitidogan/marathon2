package com.bilgeadam.soru2_hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String urunAdi;
    private int urunFiyati;

    public Urun(Integer id, String urunAdi, int urunFiyati) {
        this.id = id;
        this.urunAdi = urunAdi;
        this.urunFiyati = urunFiyati;
    }

    public Urun(String urunAdi, int urunFiyati) {
        this.urunAdi = urunAdi;
        this.urunFiyati = urunFiyati;
    }

    public Urun(Integer id) {
        this.id = id;
    }
}
