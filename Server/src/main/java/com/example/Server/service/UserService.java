package com.example.Server.service;

import com.example.Server.model.UserModel;
import com.example.Server.repository.UserRepository;
import com.example.Server.security.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public HashMap<String, String> deleteByEmailAndPassword(String email, String password) throws NoSuchAlgorithmException {
        password = Hash.hashPassword(password);
        userRepository.deleteByEmailAndPassword(email, password);
        HashMap<String, String> message = new HashMap<>();
        message.put("message", "User has been deleted");
        return message;
    }

    public UserModel saveUser(
            String email,
            String password,
            String fName,
            String lName,
            String town,
            String address,
            String zipCode,
            String phoneNumber) throws NoSuchAlgorithmException {
        UserModel user = new UserModel();

        user.setEmail(email);
        user.setPassword(Hash.hashPassword(password));
        user.setFName(fName);
        user.setLName(lName);
        user.setTown(town);
        user.setAddress(address);
        user.setZipCode(zipCode);
        user.setPhoneNumber(phoneNumber);

        return userRepository.save(user);
    }

    public Optional<UserModel> findByEmailAndPassword(String email, String password) throws NoSuchAlgorithmException {
        password = Hash.hashPassword(password);
        return userRepository.findByEmailAndPassword(email, password);
    }
}
