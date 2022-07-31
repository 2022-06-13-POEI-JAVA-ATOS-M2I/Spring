package fr.m2i.spring.lesson.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = {"user", "creationDate"})
@EqualsAndHashCode(exclude = "id")
public class Address {
    private Long id;
    private String city;
    private String street;
    private String streetNumber;
    private String apartmentNumber;
    private String zipCode;
    private LocalDateTime creationDate;
    private User user;
}