package com.j32bit.boilerplate.controller;

import com.j32bit.boilerplate.dto.UserDTO;
import com.j32bit.boilerplate.dto.UserLoginRequestDTO;
import com.j32bit.boilerplate.service.AuthenticationService;
import com.j32bit.boilerplate.service.UserService;
import com.j32bit.boilerplate.shared.GenericResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Log4j2
@RestController
@RequestMapping("api/user")
@AllArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    private final AuthenticationService authenticationService;



    @GetMapping("/user-list")
    public ResponseEntity<GenericResponse<UserDTO>> userList(){
        ArrayList<UserDTO> users = userService.findAll();
        return ResponseEntity.ok(GenericResponse.createSuccessResponse(users));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody UserLoginRequestDTO userLoginRequestDTO) throws Exception {
        return ResponseEntity.ok(authenticationService.authenticate(userLoginRequestDTO));
    }



}
