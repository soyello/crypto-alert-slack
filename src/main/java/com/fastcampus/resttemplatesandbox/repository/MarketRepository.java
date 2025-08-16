package com.fastcampus.resttemplatesandbox.repository;

import com.fastcampus.resttemplatesandbox.entity.Market;
import com.fastcampus.resttemplatesandbox.entity.QMarket;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MarketRepository {
    private final MarketJpaRepository marketJpaRepository;
    private final JPAQueryFactory jpaQueryFactory;

    public Market querydsl(String market) {
        QMarket qMarket = QMarket.market;
        BooleanBuilder condition = new BooleanBuilder();
        condition.and(
                qMarket.symbol.eq(market)
        );
        return jpaQueryFactory.selectFrom(qMarket)
                .where(condition)
                .stream().findFirst().get();

    }

    public Market jpa(String market) {
        return marketJpaRepository.findBySymbol(market).stream().findFirst().get();
    }

}
