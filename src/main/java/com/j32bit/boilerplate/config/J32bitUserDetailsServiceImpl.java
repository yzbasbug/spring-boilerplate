package com.j32bit.boilerplate.config;


import com.j32bit.boilerplate.entity.Role;
import com.j32bit.boilerplate.entity.User;
import com.j32bit.boilerplate.service.UserService;
import com.j32bit.boilerplate.service.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


/**
 * Loads CVQS user specific data.
 */
@RequiredArgsConstructor
@Log4j2
@Service
public class J32bitUserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;


    /**
     * @param username is checked against database user table
     * @return {@link  org.springframework.security.core.userdetails.User}
     * @throws UsernameNotFoundException when username is not found
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        //Get J32bitUser User
        User user = userService.findByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            log.debug("loadUserByUsername:  role is: " + role.getRoleName());
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                grantedAuthorities);
    }

}
