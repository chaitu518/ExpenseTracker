package com.expense.expensetrackersystem.dtos;

public class UserRegisterResponseDto {
    private Long id;
    private String email;

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
