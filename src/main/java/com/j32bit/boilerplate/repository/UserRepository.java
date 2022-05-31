/**
 * 
 */
package com.j32bit.boilerplate.repository;

import com.j32bit.boilerplate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.ArrayList;

/**

 *
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

	public User findByUserName(String userName);

	public ArrayList<User> findAll();
}
