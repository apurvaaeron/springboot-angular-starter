package com.apurvaaeron.springboot.angular.service;

import com.apurvaaeron.springboot.angular.dto.CountryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CountryService {

    public static final String GET_BY_CODE_URL = "https://restcountries-v1.p.rapidapi.com/alpha/";
    public static final String GET_ALL_URL = "https://restcountries-v1.p.rapidapi.com/all";
    public static final String GET_BY_PATTERN_URL = "https://restcountries-v1.p.rapidapi.com/name/";

    private static final Logger logger = LoggerFactory.getLogger(CountryService.class);

    @Autowired
    private RestTemplate restTemplate;

    public List<CountryDto> findAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", "restcountries-v1.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", "2ee5a10f58mshd1bfdccae5161f6p1f90a7jsn3628b3078651");


        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<List> resp = restTemplate.exchange(GET_ALL_URL, HttpMethod.GET, entity,
                List.class);
        return resp.getStatusCode() == HttpStatus.OK ? resp.getBody() : null;
    }

    public CountryDto find(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", "restcountries-v1.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", "2ee5a10f58mshd1bfdccae5161f6p1f90a7jsn3628b3078651");


        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<CountryDto> resp = restTemplate.exchange(GET_BY_CODE_URL + id, HttpMethod.GET, entity,
                CountryDto.class);
        return resp.getStatusCode() == HttpStatus.OK ? resp.getBody() : null;
    }

    public List<CountryDto> findAll(String pattern) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", "restcountries-v1.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", "2ee5a10f58mshd1bfdccae5161f6p1f90a7jsn3628b3078651");


        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<List> resp = restTemplate.exchange(GET_BY_PATTERN_URL + pattern, HttpMethod.GET, entity,
                List.class);
        return resp.getStatusCode() == HttpStatus.OK ? resp.getBody() : null;
    }
}
