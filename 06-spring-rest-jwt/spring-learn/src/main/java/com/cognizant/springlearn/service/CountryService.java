package com.cognizant.springlearn.service;
import com.cognizant.springlearn.model.Country;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryService {
    private final List<Country> countries = List.of(new Country("IN", "India"), new Country("US", "United States"), new Country("JP", "Japan"), new Country("DE", "Germany"));
    public Country getIndia() { return getCountry("IN"); }
    public List<Country> getAllCountries() { return countries; }
    public Country getCountry(String code) {
        return countries.stream().filter(c -> c.code().equalsIgnoreCase(code)).findFirst().orElseThrow(CountryNotFoundException::new);
    }
}
