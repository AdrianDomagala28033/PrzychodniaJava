package com.example.demo.model;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import java.util.List;

@Entity
public class Uzytkownik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imie;
    private String nazwisko;
    private String login;
    private String haslo;
    @OneToMany(mappedBy = "uzytkownik", fetch = FetchType.EAGER)
    private List<Wizyty> wizyty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

}
