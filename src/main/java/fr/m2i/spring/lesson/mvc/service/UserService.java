package fr.m2i.spring.lesson.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Double balance;

    @Autowired
    public UserService() {
        this.balance = 10d;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    public void addBalance(Double balance) {
        this.balance += balance;
    }
    
    public void decreaseBalance(Double balance) {
        this.balance -= balance;
    }
}
