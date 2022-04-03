package com.example.demo.service;


public interface IAuthenticationService {
    void authenticate(String login, String password);
    void logout();
}
