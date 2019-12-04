package com.example.springprometheusgrafana;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/custom")
public class CustomController {

    private MeterRegistry registry;

    private PersonRepository personRepository;

    @GetMapping
    @Scheduled(fixedRate = 5000)
    public void get() {
        log.info("Passou aqui!!!");
        //inprogressRequests.setToCurrentTime();
        //inprogressRequests.inc();

        Integer pendente = personRepository.countByStatus("PENDENTE");

        registry.counter("diego_counter_total").increment();
        registry.gauge("diego_gauge_total", pendente);
        //inprogressRequests.dec();
    }

}
