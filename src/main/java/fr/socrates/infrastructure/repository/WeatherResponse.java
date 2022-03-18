package fr.socrates.infrastructure.repository;

import java.util.List;

public record WeatherResponse(
        String product,
        String init,
        List<DataSerie> dataseries
) {
}
