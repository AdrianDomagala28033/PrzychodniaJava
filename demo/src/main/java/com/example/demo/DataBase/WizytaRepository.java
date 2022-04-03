package com.example.demo.DataBase;

import com.example.demo.model.Uzytkownik;
import com.example.demo.model.Wizyty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WizytaRepository extends JpaRepository<Wizyty, Long> {
    Optional<Wizyty> findWizytyByUzytkownik (Uzytkownik uzytkownik);
}
