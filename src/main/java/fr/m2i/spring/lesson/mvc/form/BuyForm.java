package fr.m2i.spring.lesson.mvc.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BuyForm {

    @Min(value = 1, message = "Vous devez entrer une valeur positive")
    @NotNull(message = "Vous devez entrer une valeur")
    private Long id;

    public BuyForm() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}
