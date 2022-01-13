package hr.matija.demopraksa.manager;

import java.util.List;
import java.util.Optional;

import hr.matija.demopraksa.domain.User;

public interface UserManager {

	User createUser(User user);

	List<User> findAllUsers();

	void deleteUserById(Long userId);

	Optional<User> getUser(Long userId);

}
