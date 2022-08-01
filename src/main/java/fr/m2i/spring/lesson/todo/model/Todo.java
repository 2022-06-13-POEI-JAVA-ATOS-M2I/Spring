package fr.m2i.spring.lesson.todo.model;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String userName;

    @Size(min = 10, message = "Enter at least 10 Characters...")
    private String description;

    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date targetDate;


    public Todo(String user, String desc, Date targetDate) {
        this.userName = user;
        this.description = desc;
        this.targetDate = targetDate;
    }

}
