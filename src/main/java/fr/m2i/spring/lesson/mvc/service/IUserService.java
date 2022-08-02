package fr.m2i.spring.lesson.mvc.service;

public interface IUserService {
    Double getBalance();
    void setBalance(Double balance);
    void addBalance(Double balance);
    void decreaseBalance(Double balance);
}
