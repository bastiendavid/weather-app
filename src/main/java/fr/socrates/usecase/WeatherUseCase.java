package fr.socrates.usecase;

import fr.socrates.domain.Weather;
import fr.socrates.infrastructure.repository.CityRepository;
import fr.socrates.infrastructure.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherUseCase {

    private CityRepository cityRepository;
    private WeatherRepository weatherRepository;

    public WeatherUseCase(CityRepository cityRepository, WeatherRepository weatherRepository) {
        this.cityRepository = cityRepository;
        this.weatherRepository = weatherRepository;
    }

    public Optional<Weather> getWeather(String cityName) {
        return cityRepository.findCity(cityName)
                .flatMap(city -> weatherRepository.weatherFor(city));
    }
}
