package com.expense.expensetrackersystem.repository;

import com.expense.expensetrackersystem.models.Expense;
import com.expense.expensetrackersystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    public List<Expense> findByUserId(Long id);

    @Query("SELECT e FROM Expense e WHERE e.user.id = :userId AND MONTH(e.date) = :month AND YEAR(e.date) = :year")
    public List<Expense> findByUserIdAndMonth(Long userId, int month, int year);
}
