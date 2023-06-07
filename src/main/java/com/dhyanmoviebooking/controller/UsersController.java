package com.dhyanmoviebooking.controller;

import com.dhyanmoviebooking.model.Users;
import com.dhyanmoviebooking.repository.UsersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {
    private final UsersRepository usersRepository;

    record NewUserRequest(
            Integer userid,
            String username,
            Integer roleid
    ){}

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public List<Users> getUsers(){
        return usersRepository.findAll();
    }

    @GetMapping("{usersid}")
    public ResponseEntity <List<Users>> getUseresById (@PathVariable("usersid") Integer usersid){
        return ResponseEntity.ok(usersRepository.findUsersByUserid(usersid));
    }

    @PostMapping
    public void AddUsers(@RequestBody NewUserRequest request){
        Users users = new Users();
        users.setUserid(request.userid());
        users.setUsername(request.username());
        users.setRoleid(request.roleid());
        usersRepository.save(users);
    }

    @DeleteMapping("{users_id}")
    public  void DeleteUsers(@PathVariable("user_id") Integer user_id){
        usersRepository.deleteById(user_id);
    }
}
