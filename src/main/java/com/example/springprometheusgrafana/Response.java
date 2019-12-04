package com.example.springprometheusgrafana;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Response {

    private String target;

    private List<String> datapoints = new ArrayList<>();
}
