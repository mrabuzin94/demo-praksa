package hr.matija.demopraksa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.matija.demopraksa.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
