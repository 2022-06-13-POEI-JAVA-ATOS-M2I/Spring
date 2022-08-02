package fr.m2i.spring.lesson.mvc.form;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Valid
public class UserForm {
    
    @Min(value = 0, message="ta grand mere")
    @NotEmpty(message = "putain")
    private Double balance;

    public UserForm() {
        
    }
    
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
