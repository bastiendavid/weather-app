package fr.socrates.infrastructure.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.socrates.domain.City;
import fr.socrates.domain.Weather;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Repository
public class WeatherRepository {

    public Optional<Weather> weatherFor(City city) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate
                .getForEntity("https://www.7timer.info/bin/civillight.php?lon=%f&lat=%f&ac=0&unit=metric&output=json&tzshift=0".formatted(city.longitude(), city.latitude()), String.class);
        try {
            WeatherResponse weatherResponse = new ObjectMapper().readValue(response.getBody(), WeatherResponse.class);
            return Optional.of(new Weather(weatherResponse.dataseries().stream().findFirst().get().weather()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
