package com.j32bit.boilerplate.service;

import com.j32bit.boilerplate.dto.UserDTO;
import com.j32bit.boilerplate.entity.User;

import java.util.ArrayList;

public interface UserService {
    /**
     *
     * @param username
     * @return the requested user if it is exists.
     */
    public User findByUsername(String username);

    /**
     *
     * @return all Users
     */
    ArrayList<UserDTO> findAll();
}
