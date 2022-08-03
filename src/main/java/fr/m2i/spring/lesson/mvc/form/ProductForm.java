package fr.m2i.spring.lesson.mvc.form;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
@Valid
public class ProductForm {

    @Min(value = 1, message = "Vous devez entrer une valeur positive")
    @NotNull(message = "Vous devez entrer une valeur")
    private Long id;

    @NotEmpty
    private String name;

    @Min(1)
    @NotNull
    private Double price;

    @Min(1)
    @NotNull
    private int quantity;
}
