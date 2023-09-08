package com.world.coviddata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CountryStatDto {


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
