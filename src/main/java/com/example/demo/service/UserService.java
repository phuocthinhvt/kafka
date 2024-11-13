package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> getUsers(int page, int size, String sortField, String sortDirection) {
        // Tạo đối tượng Pageable với phân trang và sắp xếp
        Sort sort = Sort.by(Sort.Order.by(sortField));
        if ("desc".equalsIgnoreCase(sortDirection)) {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }

        Pageable pageable = PageRequest.of(page, size, sort);
        return userRepository.findAll(pageable);
        // Trả về một Page chứa dữ liệu đã phân trang
    }
//    public List<User> getUsers() {
//        return userRepository.findAll();
//        // Trả về một Page chứa dữ liệu đã phân trang
//    }
}

