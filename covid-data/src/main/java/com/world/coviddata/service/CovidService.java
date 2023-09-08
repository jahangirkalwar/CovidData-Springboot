package com.world.coviddata.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.world.coviddata.dto.CountryStatDto;
import com.world.coviddata.entity.CountryStat;
import com.world.coviddata.repo.CountryStatRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CovidService {

//    @Value("${covid-url}")
//    private String someUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    CountryStatRepo repo;
    @Autowired
    private ModelMapper modelMapper;

    private static final String url="https://corona-virus-world-and-india-data.p.rapidapi.com/api";
    private static final String xRapidApiKey="4fd67d7aeamsh3074fca99fdc269p18e97bjsn44535c354261";

    private static final String xRapidApiHost="corona-virus-world-and-india-data.p.rapidapi.com";

    public CountryStatDto getAllCountryCovidData() {

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Key", xRapidApiKey);
            headers.set("X-RapidAPI-Host", xRapidApiHost);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);
            System.out.println("output from rapidApi :"+response.getBody());

            ObjectMapper mapper = new ObjectMapper();
            CountryStat countryStat = mapper.readValue(response.getBody(), CountryStat.class);
            System.out.println(countryStat);
            this.repo.save(countryStat);
            CountryStatDto countryStatDto = this.modelMapper.map(countryStat, CountryStatDto.class);

            return countryStatDto;

        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling endpoint of RapidApi for corona",
                    e

            );
        }

    }

}
