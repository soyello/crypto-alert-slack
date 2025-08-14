package com.fastcampus.resttemplatesandbox.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UpbitMinuteCandle {
    private String market;

    @JsonProperty("candle_date_time_utc")
    private String candleDeleteTimeUtc;

    @JsonProperty("candle_date_time_kst")
    private String candleDeleteTimeKst;

    @JsonProperty("opening_price")
    private String openingPrice;

    @JsonProperty("high_price")
    private String highPrice;

    @JsonProperty("low_price")
    private String lowPrice;

    @JsonProperty("trade_price")
    private String tradePrice;

    private String timestamp;

    @JsonProperty("candle_acc_trade_price")
    private String candleAccTradePrice;

    @JsonProperty("candle_acc_trade_volume")
    private String candleAccTradeVolume;

    private String unit;
}
