package fr.m2i.spring.lesson.mvc.form;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Valid
public class BuyForm {
    
    @Min(1)
    @NotNull
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
