package com.example.springprometheusgrafana;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@AllArgsConstructor
public class HomeController {

    private PersonRepository personRepository;

    @GetMapping
    public void get() {
        log.error("hahahahah");
    }

    @PostMapping("/search")
    public String[] search(@RequestBody String json) {
        return new String[]{"PENDENTE", "PROCESSADOS"};
    }

    @PostMapping("/query")
    public String query(@RequestBody String json) throws JsonProcessingException {

        log.info(json);

        Integer pendente = personRepository.countByStatus("PENDENTE");
        Integer processados = personRepository.countByStatus("PROCESSADOS");

        String retorno = "[{\"target\": \"PENDENTE\", \"datapoints\": [["+pendente+"]]},{\"target\": \"PROCESSADOS\", \"datapoints\": [["+processados+"]]}]";

        return retorno;
    }
}
