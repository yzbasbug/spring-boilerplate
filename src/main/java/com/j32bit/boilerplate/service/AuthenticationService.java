package com.j32bit.boilerplate.service;

import com.j32bit.boilerplate.dto.UserLoginRequestDTO;

public interface AuthenticationService {
    String authenticate(UserLoginRequestDTO userLoginRequestDTO);
}
