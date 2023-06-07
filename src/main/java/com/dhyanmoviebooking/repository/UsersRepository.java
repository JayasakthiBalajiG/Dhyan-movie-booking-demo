package com.dhyanmoviebooking.repository;

import com.dhyanmoviebooking.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository <Users, Integer> {

    List <Users> findUsersByUserid(Integer userid);
}
