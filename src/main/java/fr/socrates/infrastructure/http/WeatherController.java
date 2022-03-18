package fr.socrates.infrastructure.http;

import fr.socrates.domain.Weather;
import fr.socrates.usecase.WeatherUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class WeatherController {

    private WeatherUseCase weatherUseCase;

    public WeatherController(WeatherUseCase weatherUseCase) {
        this.weatherUseCase = weatherUseCase;
    }

    @GetMapping("/weather/{city}")
    ResponseEntity<String> weather(@PathVariable String city) {
        return weatherUseCase.getWeather(city)
                .map((weather) -> ResponseEntity.status(HttpStatus.OK).body(weather.weather()))
                .orElse(ResponseEntity.notFound().build());
    }

}
