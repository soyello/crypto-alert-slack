package com.fastcampus.resttemplatesandbox.contoller;

import com.fastcampus.resttemplatesandbox.entity.Market;
import com.fastcampus.resttemplatesandbox.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MarketController {
    private final MarketRepository marketRepository;

    @GetMapping("/api/v1/querydsl/{market}")
    public Market getMarketByQuerydsl(@PathVariable String market) {
        return marketRepository.querydsl(market);
    }

    @GetMapping("/api/v1/jpa/{market}")
    public Market getMarketByJpa(@PathVariable String market) {
        return marketRepository.jpa(market);
    }
}
