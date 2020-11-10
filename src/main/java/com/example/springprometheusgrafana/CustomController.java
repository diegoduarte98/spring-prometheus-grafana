package com.example.springprometheusgrafana;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/custom")
public class CustomController {

    private final MeterRegistry registry;

    @GetMapping
    public void get() {
        registry.counter("diego_counter_total").increment();
    }

}
