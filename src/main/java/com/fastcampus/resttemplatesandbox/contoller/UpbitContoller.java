package com.fastcampus.resttemplatesandbox.contoller;

import com.fastcampus.resttemplatesandbox.validation.MinuteCandleValidator;
import com.fastcampus.resttemplatesandbox.data.MinuteCandle;
import com.fastcampus.resttemplatesandbox.service.UpbitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UpbitContoller {
    private final MinuteCandleValidator minuteCandleValidator;
    private final UpbitService upbitService;

    public UpbitContoller(MinuteCandleValidator minuteCandleValidator, UpbitService upbitService) {
        this.minuteCandleValidator = minuteCandleValidator;
        this.upbitService = upbitService;
    }

    @GetMapping("/api/v1/candles/minutes/{unit}")
    public List<MinuteCandle> getMinuteCandle(
            @PathVariable int unit,
            @RequestBody MinuteCandleRequest request,
            BindingResult bindingResult
    ) throws JsonProcessingException {
        minuteCandleValidator.validate(unit, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ArrayList<>();
        }

        return upbitService.getCandle(unit, request);
    }
}
