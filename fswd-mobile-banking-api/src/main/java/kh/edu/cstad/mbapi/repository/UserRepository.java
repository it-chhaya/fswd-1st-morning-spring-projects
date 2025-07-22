package kh.edu.cstad.mbapi.repository;

import kh.edu.cstad.mbapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
