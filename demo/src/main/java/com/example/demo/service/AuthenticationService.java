package com.example.demo.service;

import com.example.demo.DataBase.UzytkownikRepository;
import com.example.demo.model.Uzytkownik;
import com.example.demo.session.ObiektSesji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AuthenticationService implements IAuthenticationService{

    @Autowired
    UzytkownikRepository userDAO;

    @Resource
    ObiektSesji sessionObject;

    @Override
    public void authenticate(String login, String password) {
        Optional<Uzytkownik> userBox = this.userDAO.findUzytkownikByLogin(login);
        if(userBox.isPresent() &&
                userBox.get().getHaslo()
                        .equals(password)) {
            this.sessionObject.setUser(userBox.get());
        }
    }

    @Override
    public void logout() {
        this.sessionObject.setUser(null);
    }
}
