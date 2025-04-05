package com.expense.expensetrackersystem.controller;

import com.expense.expensetrackersystem.dtos.ExpenseRequestDto;
import com.expense.expensetrackersystem.models.Expense;
import com.expense.expensetrackersystem.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin
public class ExpenseController {
    private ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@RequestBody ExpenseRequestDto expenseRequestDto) {
        return ResponseEntity.ok(expenseService.addExpense(expenseRequestDto.getUserId(),expenseRequestDto.getCategory(),expenseRequestDto.getAmount(),expenseRequestDto.getDate(),expenseRequestDto.getDescription()));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Expense>> getExpenses(@PathVariable Long userId) {
        return ResponseEntity.ok(expenseService.getExpenses(userId));
    }

    @GetMapping("/{userId}/monthly")
    public ResponseEntity<List<Expense>> getMonthlyExpenses(
            @PathVariable Long userId,
            @RequestParam int month,
            @RequestParam int year) {
        return ResponseEntity.ok(expenseService.getMonthlyExpenses(userId, month, year));
    }
}

