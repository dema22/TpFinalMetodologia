package com.utn.MatafuegosMarplatense.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "fire_extinguisher_brand")

public class FireExtinguisherBrand {
    @Id
    @Column(name = "id_brand")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBrand;

    @Column(name = "brand_name")
    @NotNull
    private String brandName;
}
