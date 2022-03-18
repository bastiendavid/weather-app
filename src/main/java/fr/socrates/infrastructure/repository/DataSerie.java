package fr.socrates.infrastructure.repository;

public record DataSerie(
        Long date,
        String weather,
        Temp2m temp2m,
        Integer wind10m_max) {
}
