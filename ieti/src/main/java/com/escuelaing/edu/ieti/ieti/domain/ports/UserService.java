package com.escuelaing.edu.ieti.ieti.domain.ports;

import com.escuelaing.edu.ieti.ieti.domain.model.User;

import java.util.Collection;
import java.util.List;

public interface UserService {
    User getUser(String name);

    Collection<User> getUsers();

    User deleteUsers(String name);


    User postUser(User user);

    User patchUser(String name, User user);
}
