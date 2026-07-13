package com.cognizant.ormlearn.service;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CountryService {
    private final CountryRepository countryRepository;
    public CountryService(CountryRepository countryRepository) { this.countryRepository = countryRepository; }
    @Transactional(readOnly = true) public List<Country> getAllCountries() { return countryRepository.findAll(); }
    @Transactional(readOnly = true) public Country findByCode(String code) { return countryRepository.findById(code.toUpperCase()).orElseThrow(); }
    @Transactional public Country addCountry(Country country) { return countryRepository.save(country); }
    @Transactional(readOnly = true) public List<Country> search(String text) { return countryRepository.findByNameContainingIgnoreCase(text); }
}
