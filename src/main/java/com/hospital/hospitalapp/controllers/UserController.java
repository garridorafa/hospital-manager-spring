package com.hospital.hospitalapp.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.hospital.hospitalapp.models.UserModel;
import com.hospital.hospitalapp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUser(){
        return userService.getUsers();
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user){
        return userService.saveUser(user);
    }

    @GetMapping(path = "{id}")
    public Optional<UserModel> getById(@PathVariable("id") Long id){
        return userService.getById(id);
    }

    @GetMapping("/query")
    public ArrayList<UserModel> getByAge(@RequestParam("age") Integer age){
        return userService.getByAge(age);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = userService.deleteUser(id);
        if (ok){
            return "User deleted";
        }else{
            return "Cannot user delete";
        }
    }
}
