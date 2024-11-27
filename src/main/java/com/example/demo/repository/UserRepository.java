package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    // Không cần phải viết truy vấn thủ công, Spring Data JPA sẽ tự động xử lý.
}

