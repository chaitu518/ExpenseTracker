package com.expense.expensetrackersystem.dtos;

public class ExpenseRequestDto {
    private Long userId;
    private String category;
    private Double amount;
    private String date;
    private String description;

    public Long getUserId() {
        return this.userId;
    }

    public String getCategory() {
        return this.category;
    }

    public Double getAmount() {
        return this.amount;
    }

    public String getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
