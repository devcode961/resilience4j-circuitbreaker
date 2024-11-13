package com.example.circuitbreaker.controller;

import com.example.circuitbreaker.model.Brewery;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/breweries")
@RequiredArgsConstructor
public class BreweryController {

    private static final Logger log = LoggerFactory.getLogger(BreweryController.class);
    //This api returns a list of breweries
    private final static String BREWERY_API_URL = "https://api.openbrewerydb.org/v1/breweries";
    private final RestTemplate restTemplate;
    private final CircuitBreaker circuitBreaker;

    @GetMapping
    public ResponseEntity<?> getActivity() {
        return circuitBreaker.run(() -> {
            Brewery[] breweries = restTemplate.getForObject(BREWERY_API_URL, Brewery[].class);
            if (breweries != null) {
                List<Brewery> breweryList = Arrays.asList(breweries);
                breweryList.forEach(brewery -> log.info("Brewery: {}", brewery));
                return ResponseEntity.ok(breweryList);
            }
            return ResponseEntity.ok("No breweries found for the given criteria");
        }, throwable -> {
            log.error("Error occurred: {}", throwable.getMessage());
            return ResponseEntity.ok("Error occurred while fetching breweries. Please try again later");
        });
    }
}
