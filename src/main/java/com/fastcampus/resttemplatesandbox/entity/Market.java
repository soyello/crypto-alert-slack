package com.fastcampus.resttemplatesandbox.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "MARKETS")
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MARKET_ID")
    private Long Id;

    @Column(name = "MARKET_SYMBOL", nullable = false, length = 100)
    private String symbol;

    @Column(name = "MARKET_KOREAN_NAME", nullable = false, length = 100)
    private String koreanName;

    @Column(name = "MARKET_ENGLISH_NAME", nullable = false, length = 100)
    private String englishName;

    @Column(name = "MARKET_WARNING", nullable = false, length = 100)
    private String warning;

    protected Market() {

    }

    public Market(String symbol, String koreanName, String englishName, String warning) {
        this.symbol = symbol;
        this.koreanName = koreanName;
        this.englishName = englishName;
        this.warning = warning;
    }

    public Long getId() {
        return Id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getWarning() {
        return warning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Market market)) return false;
        return Objects.equals(getId(), market.getId()) && Objects.equals(getSymbol(), market.getSymbol()) && Objects.equals(getKoreanName(), market.getKoreanName()) && Objects.equals(getEnglishName(), market.getEnglishName()) && Objects.equals(getWarning(), market.getWarning());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSymbol(), getKoreanName(), getEnglishName(), getWarning());
    }
}
