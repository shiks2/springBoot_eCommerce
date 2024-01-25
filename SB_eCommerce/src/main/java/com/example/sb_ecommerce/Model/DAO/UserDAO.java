package com.example.sb_ecommerce.Model.DAO;

import com.example.sb_ecommerce.Model.LocalUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDAO extends CrudRepository<LocalUser, Long> {
    Optional<LocalUser> findByEmailIgnoreCase(String email);

    Optional<LocalUser> findByUsernameIgnoreCase(String username);


}
