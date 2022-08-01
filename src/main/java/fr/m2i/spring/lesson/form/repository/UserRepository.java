package fr.m2i.spring.lesson.form.repository;


import fr.m2i.spring.lesson.form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}