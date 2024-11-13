package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint phân trang cho User
    @GetMapping("/users")
    public Page<User> getUsers(
            @RequestParam(defaultValue = "0") int page,       // Mặc định là trang 0
            @RequestParam(defaultValue = "10") int size,      // Mặc định là 10 mục mỗi trang
            @RequestParam(defaultValue = "name") String sortField, // Sắp xếp theo trường 'name'
            @RequestParam(defaultValue = "asc") String sortDirection) { // Sắp xếp theo thứ tự tăng dần (asc)

        return userService.getUsers(page, size, sortField, sortDirection);
    }
//    public List<User> getUsers() { // Sắp xếp theo thứ tự tăng dần (asc)
//
//        return userService.getUsers();
//    }
}

