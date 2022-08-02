package fr.m2i.spring.lesson.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private Double balance;

    @Autowired
    public UserService() {
        this.balance = 10d;
    }

    @Override
    public Double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    @Override
    public void addBalance(Double balance) {
        this.balance += balance;
    }
    
    @Override
    public void decreaseBalance(Double balance) {
        this.balance -= balance;
    }
}
