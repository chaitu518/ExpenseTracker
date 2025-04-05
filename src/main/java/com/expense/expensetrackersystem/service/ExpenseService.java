package com.expense.expensetrackersystem.service;

import com.expense.expensetrackersystem.models.Expense;
import com.expense.expensetrackersystem.models.User;
import com.expense.expensetrackersystem.repository.ExpenseRepository;
import com.expense.expensetrackersystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private ExpenseRepository expenseRepository;
    private UserRepository userRepository;
    public ExpenseService(ExpenseRepository expenseRepository,UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }
    public Expense addExpense(Long userId,String category,Double amount,String date,String description) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        Expense expense = new Expense();
        expense.setCategory(category);
        expense.setAmount(amount);
        expense.setUser(optionalUser.get());
        expense.setDescription(description);
        expense.setDate(LocalDate.parse(date));

        return expenseRepository.save(expense);
    }

    public List<Expense> getExpenses(Long userId) {
        return expenseRepository.findByUserId(userId);
    }

    public List<Expense> getMonthlyExpenses(Long userId, int month, int year) {
        return expenseRepository.findByUserIdAndMonth(userId,month,year);
    }
}
