package com.astra_life.testing.backend.controllers;

import com.astra_life.testing.backend.dtos.UserDto;
import com.astra_life.testing.backend.models.UserModel;
import com.astra_life.testing.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public Map<String, Object> createData(@RequestBody UserDto request){
        return userService.createData(request);
    }

    @GetMapping("/")
    public  Map<String, Object> getAllData(Pageable page){
        return userService.readData(page);
    }

    @GetMapping("/{id}")
    public  Map<String, Object> findDataById(@PathVariable("id") UserModel model){
        return userService.findDataById(model);
    }

    @GetMapping("/delete/{id}")
    public  Map<String, Object> deleteData(@PathVariable("id") UserModel model){
        return userService.deleteData(model);
    }

    @PostMapping("/update/{id}")
    public Map<String, Object> updateData(@PathVariable("id") UserModel model, @RequestBody UserDto request){
        return userService.updateData(model,request);
    }
}
