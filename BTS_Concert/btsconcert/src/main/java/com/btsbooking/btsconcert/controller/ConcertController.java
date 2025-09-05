package com.btsbooking.btsconcert.controller;

import com.btsbooking.btsconcert.model.Concert;
import com.btsbooking.btsconcert.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ConcertController {

    @Autowired
    private ConcertRepository concertRepo;

    @GetMapping("/concerts")
    public List<Concert> getUpcomingConcerts() {
        return concertRepo.findAll().stream()
                .filter(c -> c.getConcertDate() != null && c.getConcertDate().isAfter(LocalDate.now()))
                .sorted(Comparator.comparing(Concert::getConcertDate))
                .collect(Collectors.toList());
    }
}
