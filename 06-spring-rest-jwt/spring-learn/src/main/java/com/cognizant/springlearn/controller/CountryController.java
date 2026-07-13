package com.cognizant.springlearn.controller;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CountryController {
    private final CountryService countryService;
    public CountryController(CountryService countryService) { this.countryService = countryService; }
    @RequestMapping("/country") public Country getCountryIndia() { return countryService.getIndia(); }
    @GetMapping("/countries") public List<Country> getAllCountries() { return countryService.getAllCountries(); }
    @GetMapping({"/country/{code}", "/countries/{code}"}) public Country getCountry(@PathVariable String code) { return countryService.getCountry(code); }
}
