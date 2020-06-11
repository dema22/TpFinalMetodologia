package com.utn.MatafuegosMarplatense.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.MatafuegosMarplatense.models.FireExtinguisherBrand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class FireExtinguisherDTO {
    @JsonProperty
    private FireExtinguisherBrand fireExtinguisherBrand;

    @JsonProperty
    private String fireExtinguishingAgent;

    @JsonProperty
    private Float fireExtinguisherCapacity;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @JsonProperty
    private Date dateFabrication;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @JsonProperty
    private Date loadingDate;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @JsonProperty
    private Date dateHydraulicTest;

    @JsonProperty
    private String barcode;

    @JsonProperty
    private Boolean certificacionBureauBeritas;
}
