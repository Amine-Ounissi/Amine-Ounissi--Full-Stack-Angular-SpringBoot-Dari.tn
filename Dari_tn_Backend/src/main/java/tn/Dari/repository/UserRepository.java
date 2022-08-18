package tn.Dari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.Dari.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
  Optional<User>  findByEmail(String email);
  Optional<User>  findByIdU(Long id);
  boolean existsByEmail(String email);
}
