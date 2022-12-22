package com.spring.market.online_market.aop;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class AopController {
    public final ServiceTimer serviceTimer;

    @GetMapping("/statistic")
    public String showStatistic() {
        return serviceTimer.timerToString();
    }
}
