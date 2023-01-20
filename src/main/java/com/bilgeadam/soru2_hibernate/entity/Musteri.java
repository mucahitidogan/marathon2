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
public class Musteri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String adi;
    private String soyadi;

    public Musteri(Integer id, String adi, String soyadi) {
        this.id = id;
        this.adi = adi;
        this.soyadi = soyadi;
    }

    public Musteri(String adi, String soyadi) {
        this.adi = adi;
        this.soyadi = soyadi;
    }

    public Musteri(Integer id) {
        this.id = id;
    }
}
