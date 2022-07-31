package fr.m2i.spring.lesson.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "email")
@ToString(exclude = {"lastModifiedPassword"})
public class Credentials {
    private String email;
    private String password;
    private LocalDateTime lastModifiedPassword;
}
