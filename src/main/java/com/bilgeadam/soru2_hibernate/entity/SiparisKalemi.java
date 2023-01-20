package com.bilgeadam.soru2_hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class SiparisKalemi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private Urun urun;

   private int urunAdedi;

    public SiparisKalemi(Integer id, Urun urun, int urunAdedi) {
        this.id = id;
        this.urun = urun;
        this.urunAdedi = urunAdedi;
    }

    public SiparisKalemi(Urun urun, int urunAdedi) {
        this.urun = urun;
        this.urunAdedi = urunAdedi;
    }

    public SiparisKalemi(Integer id) {
        this.id = id;
    }
}
