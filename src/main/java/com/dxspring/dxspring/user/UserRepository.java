package com.dxspring.dxspring.user;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT Data FROM User Data WHERE Data.email = ?1")
    Optional<User> findByEmail(String email);
}
