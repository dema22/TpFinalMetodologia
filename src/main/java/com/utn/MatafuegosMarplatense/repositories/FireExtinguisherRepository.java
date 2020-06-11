package com.utn.MatafuegosMarplatense.repositories;

import com.utn.MatafuegosMarplatense.models.FireExtinguisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FireExtinguisherRepository extends JpaRepository<FireExtinguisher, Integer> {

    @Query(value = "select * from fire_extinguisher where id_client = :idClient ;", nativeQuery = true)
    List<FireExtinguisher> getAllFireExtinguishersById(@PathVariable("idClient") Integer idClient);
}
