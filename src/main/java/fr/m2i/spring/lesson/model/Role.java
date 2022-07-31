package fr.m2i.spring.lesson.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = {"user","creationDate"})
@EqualsAndHashCode(of = {"roleType", "user"})
public class Role {
    private Long id;
    private RoleType roleType;
    private LocalDateTime creationDate = LocalDateTime.now();

    private User user;

    public Role(RoleType roleType) {
        this.roleType = roleType;
    }
}
