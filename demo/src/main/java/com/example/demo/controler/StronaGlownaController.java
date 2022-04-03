package com.example.demo.controler;

import com.example.demo.model.Uzytkownik;
import com.example.demo.service.IAuthenticationService;
import com.example.demo.session.ObiektSesji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;


@Controller
public class StronaGlownaController {

    @Autowired
    private IAuthenticationService authenticationService;

    @Resource
    private ObiektSesji sessionObject;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {return "Main";}

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password) {
        if(!this.sessionObject.isLogged()) {
            this.authenticationService.authenticate(login, password);
        }
        if(sessionObject.isLogged()) {
            return "Main";
        } else {
            return "login";
        }
    }
    @RequestMapping(value = "/wizyty", method = RequestMethod.POST)
    public String rezerwacjaWizyty()
    {
        if(sessionObject.isLogged()) {
            return "wizyty";
        } else {
            return "login";
        }
    }
}
