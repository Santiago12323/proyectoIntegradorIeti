package com.escuelaing.edu.ieti.ieti.infrastructure.controller;


import com.escuelaing.edu.ieti.ieti.domain.model.User;
import com.escuelaing.edu.ieti.ieti.domain.ports.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> getUser(@RequestParam("name") String name){
        try{
            return ResponseEntity.ok(userService.getUser(name));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(Map.of("message" , e.getMessage()));
        }
    }

    @PostMapping("/user")
    public ResponseEntity<?> postUser(@RequestBody User user){
        try{
            return ResponseEntity.ok(userService.postUser(user));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(Map.of("message" , e.getMessage()));
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(){
        try{
            return ResponseEntity.ok(userService.getUsers());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(Map.of("message" , e.getMessage()));
        }
    }

    @DeleteMapping("/user")
    public ResponseEntity<?> deleteUsers(@RequestParam("name") String name){
        try{
            return ResponseEntity.ok(userService.deleteUsers(name));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(Map.of("message" , e.getMessage()));
        }
    }

    @PatchMapping("/user")
    public ResponseEntity<?> patchUsers(@RequestParam("name") String name,@RequestBody User user){
        try{
            return ResponseEntity.ok(userService.patchUser(name,user));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(Map.of("message" , e.getMessage()));
        }
    }
}
