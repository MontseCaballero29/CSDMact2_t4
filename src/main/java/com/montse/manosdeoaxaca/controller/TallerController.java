package com.montse.manosdeoaxaca.controller;

import com.montse.manosdeoaxaca.dto.TallerDTO;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/talleres")
public class TallerController {

    private static final String API_URL =
            "https://6a545ff38547b9f7111c26d6.mockapi.io/talleres";

    private final RestClient restClient = RestClient.create();

    /*Devuelve todos los talleres obtenidos desde la API externa. */
    @GetMapping
    public List<Map<String, Object>> obtenerTalleres() {

        List<Map<String, Object>> talleres = restClient
                .get()
                .uri(API_URL)
                .retrieve()
                .body(
                    new ParameterizedTypeReference<
                            List<Map<String, Object>>>() {
                    }
                );

        return talleres == null
                ? List.of()
                : talleres;
    }

    /*Devuelve el nombre y la ubicación del primer taller disponible.*/
    @GetMapping("/ubicacion")
    public Map<String, Object> obtenerUbicacionTaller() {

        List<Map<String, Object>> talleres =
                obtenerTalleres();

        if (talleres.isEmpty()) {
            return Map.of(
                    "mensaje",
                    "No se encontraron talleres"
            );
        }

        Map<String, Object> primerTaller =
                talleres.get(0);

        Map<String, Object> respuesta =
                new LinkedHashMap<>();

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

    /*
     * Endpoint rest Recibe un objeto TallerDTO en formato JSON por @RequestBody y devuelve el mismo objeto
     */
    @PostMapping("/crear")
    public TallerDTO crearTaller(
            @RequestBody TallerDTO taller) {

        return taller;
    }
}