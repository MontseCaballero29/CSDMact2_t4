package com.montse.manosdeoaxaca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProyectoController {

    @GetMapping("/proyecto")
    public String mostrarProyecto() {
        return "Manos de Oaxaca - Dalia Montserrat";
    }
}
 /* Este archivo hace lo siguiente:

@RestController indica que la clase atenderá peticiones web y devolverá directamente su respuesta.
@GetMapping("/proyecto") crea el endpoint GET /proyecto.
El método devuelve un texto al navegador. */
