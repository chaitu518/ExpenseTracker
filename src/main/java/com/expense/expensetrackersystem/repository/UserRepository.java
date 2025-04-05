package com.expense.expensetrackersystem.repository;

import com.expense.expensetrackersystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String Email);
}
