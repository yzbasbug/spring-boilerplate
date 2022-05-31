package com.j32bit.boilerplate.service.implementation;

import com.j32bit.boilerplate.dto.RoleDTO;
import com.j32bit.boilerplate.dto.UserDTO;
import com.j32bit.boilerplate.entity.Role;
import com.j32bit.boilerplate.entity.User;
import com.j32bit.boilerplate.repository.UserRepository;
import com.j32bit.boilerplate.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " not found in database.");
        }
        log.debug("UserDetailServiceImpl: loadUserByUsername method completed.");
        return user;
    }

    @Override
    public ArrayList<UserDTO> findAll() {
        ArrayList<User> users = userRepository.findAll();
        ArrayList<UserDTO> userDtos = new ArrayList<>();
        for(User user : users) {
            UserDTO userDto = new UserDTO();
            BeanUtils.copyProperties(user,userDto);
            List<Role> roles = user.getRoles();
            List<RoleDTO> roleDTOs = new ArrayList<>();
            for(Role role : roles){
                RoleDTO roleDTO = new RoleDTO();
                BeanUtils.copyProperties(role,roleDTO);
                roleDTOs.add(roleDTO);
            }
            userDto.setRoles(roleDTOs);
            userDtos.add(userDto);
        }
        return userDtos;
    }
}
