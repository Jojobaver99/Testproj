package security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import security.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
User findByUsername(String username);
}
