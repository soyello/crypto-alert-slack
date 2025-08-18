package com.fastcampus.resttemplatesandbox.service;

import com.fastcampus.resttemplatesandbox.http.UpbitFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpbitMinuteCandleService {

    private final UpbitFeignClient upbitFeignClient;

    public void callUpbit(int unit, String market) {
        String result = upbitFeignClient.getMinuteCandle(unit, market, 2);
        System.out.println(result);
    }
}
