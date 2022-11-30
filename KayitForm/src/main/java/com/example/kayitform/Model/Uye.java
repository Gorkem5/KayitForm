package com.example.kayitform.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "kullanici")
public class Uye {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isim;
    private String soyisim;
    private String eposta;

    public Uye(Long id, String isim, String soyisim, String eposta) {
        this.id = id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.eposta = eposta;
    }

    public Uye() {
    }
}