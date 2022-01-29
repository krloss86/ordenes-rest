package ar.com.educacionit.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.educacionit.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsBySocio_Email(String email);

}
