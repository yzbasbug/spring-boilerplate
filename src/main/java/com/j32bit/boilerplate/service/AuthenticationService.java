package com.j32bit.boilerplate.service;

import com.j32bit.boilerplate.dto.UserLoginRequestDTO;

public interface AuthenticationService {
    /**
     *
     * @param userLoginRequestDTO
     * @return generated token to access the other secured resources
     */
    String authenticate(UserLoginRequestDTO userLoginRequestDTO);
}
