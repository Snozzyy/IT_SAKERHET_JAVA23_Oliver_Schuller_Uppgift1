package com.example.Server.controller;

import com.example.Server.model.UserModel;
import com.example.Server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }

    // Shouldn't authorize by only ID, change to JWT
    @GetMapping(value = "/my-details")
    public Optional<UserModel> getMyDetails(
            @RequestParam(value = "id") long id
    ) {
        return userService.findById(id);
    }

    // Optimal would be to not use ID like this to prevent IDOR attack
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> deleteUser(
            @RequestParam(value = "id") long id
    ) {
        return new ResponseEntity<>(userService.deleteById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Object> registerUser(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "fname") String fName,
            @RequestParam(value = "lname") String lName,
            @RequestParam(value = "town") String town,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "zip-code") String zipCode,
            @RequestParam(value = "phone-number") String phoneNumber
    ) throws NoSuchAlgorithmException {
      return new ResponseEntity<>(userService.saveUser(email, password, fName, lName, town, address, zipCode, phoneNumber), HttpStatus.CREATED);
    }


}
