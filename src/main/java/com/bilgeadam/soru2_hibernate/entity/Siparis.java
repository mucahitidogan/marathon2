package com.bilgeadam.soru2_hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Musteri musteri;

    @OneToMany(cascade = CascadeType.ALL)
    private List<SiparisKalemi> siparisKalemi;

    public Siparis(Integer id, Musteri musteri, List<SiparisKalemi> siparisKalemi) {
        this.id = id;
        this.musteri = musteri;
        this.siparisKalemi = siparisKalemi;
    }

    public Siparis(Musteri musteri, List<SiparisKalemi> siparisKalemi) {
        this.musteri = musteri;
        this.siparisKalemi = siparisKalemi;
    }

    public Siparis(Integer id) {
        this.id = id;
    }
}
