package com.utn.MatafuegosMarplatense.models;

import com.sun.istack.NotNull;
import com.utn.MatafuegosMarplatense.dtos.FireExtinguisherDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "client")

public class Client {
    @Id
    @Column(name = "id_client")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;

    @Column(name = "client_name")
    @NotNull
    private String clientName;

    @NotNull
    private String city;

    @Column(name = "contact_number")
    @NotNull
    private String contactNumber;

    @Transient
    List<FireExtinguisherDTO> clientFireExtinguishers;
}
