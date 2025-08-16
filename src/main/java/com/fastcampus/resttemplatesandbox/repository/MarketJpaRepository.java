package com.fastcampus.resttemplatesandbox.repository;

import com.fastcampus.resttemplatesandbox.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarketJpaRepository extends JpaRepository<Market, Integer> {
    List<Market> findBySymbol(String symbol);
}
