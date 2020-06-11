package com.utn.MatafuegosMarplatense.repositories;

import com.utn.MatafuegosMarplatense.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
