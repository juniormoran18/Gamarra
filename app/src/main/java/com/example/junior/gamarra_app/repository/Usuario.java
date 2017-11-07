package com.example.junior.gamarra_app.repository;

import com.example.junior.gamarra_app.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junior on 31/10/17.
 */

public class Usuario {
    private static Usuario _INSTANCE = null;

    public static Usuario getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new Usuario();
        return _INSTANCE;
    }

    private Usuario(){

        agregarUser(new User(1,"cliente","pass","junior","junior.moran@tecsup.edu.pe","Av. Los Nogales",988979683));
        agregarUser(new User(2,"comerciante","pass","rodolfo","junior.moran@tecsup.edu.pe","Av. Los Nogales",988979683));

    }

    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {return this.users;}

    public void agregarUser(User user){
        this.users.add(user);
    }




}