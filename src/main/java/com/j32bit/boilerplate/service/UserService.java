package com.j32bit.boilerplate.service;

import com.j32bit.boilerplate.dto.UserDTO;
import com.j32bit.boilerplate.entity.User;

import java.util.ArrayList;

public interface UserService {
    public User findByUsername(String username);

    ArrayList<UserDTO> findAll();
}
