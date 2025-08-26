package com.escuelaing.edu.ieti.ieti.domain.Usecases;


import com.escuelaing.edu.ieti.ieti.domain.model.User;
import com.escuelaing.edu.ieti.ieti.domain.ports.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {
    HashMap<String, User> users = new HashMap<>();

    @Override
    public User getUser(String name){
        return users.get(name);
    }

    @Override
    public Collection<User> getUsers() {
        return users.values();
    }

    @Override
    public User deleteUsers(String name){
        return users.remove(name);
    }

    @Override
    public User postUser(User user){
        users.put(user.getName(),user);
        return user;
    }

    @Override
    public User patchUser(String name, User user) {
        User existingUser = users.get(name);
        if (existingUser == null) {
            return null; // o lanzar excepción si quieres
        }

        if (user.getName() != null) {
            existingUser.setName(user.getName());
        }
        if (user.getLastName() != null) {
            existingUser.setLastName(user.getLastName());
        }
        if (user.getIdentification() != null) {
            existingUser.setIdentification(user.getIdentification());
        }

        if (user.getName() != null && !user.getName().equals(name)) {
            users.remove(name);
            users.put(user.getName(), existingUser);
        } else {
            users.put(name, existingUser);
        }

        return existingUser;
    }

}
