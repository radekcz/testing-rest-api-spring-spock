package cz.rk.spring.service;

import cz.rk.spring.dto.Stats;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor
@Service
public class StatsService {

    public List<Stats> getStats() {
        return IntStream
                .range(200, 205)
                .mapToObj(i -> new Stats(String.format("Status: %d", i)))
                .collect(Collectors.toList());
    }
}
