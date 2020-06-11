package com.utn.MatafuegosMarplatense.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "fire_extinguisher")

public class FireExtinguisher {
    @Id
    @Column(name = "id_fire_extinguisher")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFireExtinguisher;

    @ManyToOne(optional = false)
    @JoinColumn(name="id_client")
    private Client client;

    @ManyToOne(optional = false)
    @JoinColumn(name="id_brand")
    private FireExtinguisherBrand fireExtinguisherBrand;

    @Column(name = "fire_extinguishing_agent")
    @NotNull
    private String fireExtinguishingAgent;

    @Column(name = "fire_extinguisher_capacity")
    @NotNull
    private Float fireExtinguisherCapacity;

    @Column(name = "date_fabrication")
    @NotNull
    private Date dateFabrication;

    @Column(name = "loading_date")
    @NotNull
    private Date loadingDate;

    @Column(name = "date_hydraulic_test")
    @NotNull
    private Date dateHydraulicTest;

    @NotNull
    private String barcode;

    // OPDS ?

    @Column(name = "certification_bureau_veritas")
    @NotNull
    private Boolean certificacionBureauBeritas;
}
