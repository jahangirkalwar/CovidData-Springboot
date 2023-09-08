package com.world.coviddata.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class CountryStat {

    @Id
    UUID randomId = UUID.randomUUID();
    private String country_name;
    private Long cases;
    private Long deaths;

    private String region;

    private Long recovered;

    private Long newDeaths;

    private Long newCases;

    private Long serious_critical;

    private Long activeCases;

    private Long totalCasesPer1mPopulation;

    private Long totalDeathsPer1mPopulation;

    private Long totalTests;

    private Long testsPer1mPopulation;

}
