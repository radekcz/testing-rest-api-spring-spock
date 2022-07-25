package cz.rk.spring.controller;

import cz.rk.spring.dto.Stats;
import cz.rk.spring.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class StatsController {

    private final StatsService statsService;

    @GetMapping(value = "stats")
    public List<Stats> getStats() {
        return statsService.getStats();
    }

}
