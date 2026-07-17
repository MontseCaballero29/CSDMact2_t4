package com.montse.manosdeoaxaca.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/talleres")
public class TallerController {

    private static final String API_URL =
            "https://6a545ff38547b9f7111c26d6.mockapi.io/talleres";

    private final RestClient restClient = RestClient.create();

    /*Inciso b:*/
     
    @GetMapping
    public List<Map<String, Object>> obtenerTalleres() {

        List<Map<String, Object>> talleres = restClient
                .get()
                .uri(API_URL)
                .retrieve()
                .body(new ParameterizedTypeReference<List<Map<String, Object>>>() {
                });

        return talleres == null ? List.of() : talleres;
    }

    /*Inciso c:**/
   
    @GetMapping("/ubicacion")
    public Map<String, Object> obtenerUbicacionTaller() {

        List<Map<String, Object>> talleres = obtenerTalleres();

        if (talleres.isEmpty()) {
            return Map.of(
                    "mensaje",
                    "No se encontraron talleres"
            );
        }

        Map<String, Object> primerTaller = talleres.get(0);

        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put(
                "nombreTaller",
                primerTaller.get("nombreTaller")
        );
        respuesta.put(
                "ubicacion",
                primerTaller.get("ubicacion")
        );

        return respuesta;
    }
}