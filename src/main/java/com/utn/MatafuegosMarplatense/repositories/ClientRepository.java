package com.utn.MatafuegosMarplatense.repositories;

import com.utn.MatafuegosMarplatense.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
