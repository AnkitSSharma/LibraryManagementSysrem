package com.example.LibraryManagementSysrem.Repositories;

import com.example.LibraryManagementSysrem.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByName(String username);

    boolean existsByName(String username);

    boolean existsByEmail(String email);

    User getByEmail(String  email);

    User getByName(String name);
    Long getIdByName(String name);
}
