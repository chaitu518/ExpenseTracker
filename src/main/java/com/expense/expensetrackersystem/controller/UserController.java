package com.expense.expensetrackersystem.controller;

import com.expense.expensetrackersystem.dtos.UserRegisterResponseDto;
import com.expense.expensetrackersystem.models.User;
import com.expense.expensetrackersystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> registerUser(@RequestBody User user) {
        User user1 = userService.registerUser(user);
        UserRegisterResponseDto userRegisterResponseDto = new UserRegisterResponseDto();
        userRegisterResponseDto.setEmail(user1.getEmail());
        userRegisterResponseDto.setId(user1.getId());
        return new ResponseEntity<>(userRegisterResponseDto, HttpStatus.OK);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}

