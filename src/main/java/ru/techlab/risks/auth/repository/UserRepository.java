package ru.techlab.risks.auth.repository;

import org.springframework.data.repository.CrudRepository;
import ru.techlab.risks.auth.model.User;

import org.springframework.cache.annotation.Cacheable;

import java.util.Optional;

/**
 * Created by dim777999 on 09.10.2017.
 */
@Cacheable("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> getUserByEmail(String email);
}
