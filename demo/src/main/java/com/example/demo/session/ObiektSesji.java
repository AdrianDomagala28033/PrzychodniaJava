package com.example.demo.session;

import com.example.demo.model.Uzytkownik;
import com.example.demo.model.Wizyty;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class ObiektSesji {
    private Uzytkownik user = null;
    private Wizyty wizyty = new Wizyty();
    public boolean isLogged() {
        return this.user != null;
    }

    public Uzytkownik getUser() {
        return user;
    }

    public void setUser(Uzytkownik user) {
        this.user = user;
    }

    public Wizyty getWizyty() {
        return wizyty;
    }

    public void setWizyty(Wizyty cart) {
        this.wizyty = wizyty;
    }
}
