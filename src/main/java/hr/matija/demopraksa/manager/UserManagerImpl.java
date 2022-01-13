package hr.matija.demopraksa.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import hr.matija.demopraksa.domain.User;
import hr.matija.demopraksa.repository.UserRepository;

@Service
public class UserManagerImpl implements UserManager {

	private final UserRepository userRepository;

	public UserManagerImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override public void deleteUserById(Long userId) {
		userRepository.deleteById(userId);
	}

	@Override public Optional<User> getUser(Long userId) {
		return userRepository.findById(userId);
	}
}
