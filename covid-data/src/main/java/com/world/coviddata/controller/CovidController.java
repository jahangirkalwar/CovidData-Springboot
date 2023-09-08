package com.world.coviddata.controller;

import com.world.coviddata.dto.CountryStatDto;
import com.world.coviddata.service.CovidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid")
@RequiredArgsConstructor
public class CovidController {

    private final CovidService covidService;

    @GetMapping("get-covid-data")
    public ResponseEntity<CountryStatDto> callRapidEndpointToGetCovidData(){

        return ResponseEntity.ok(covidService.getAllCountryCovidData());

    }


}
