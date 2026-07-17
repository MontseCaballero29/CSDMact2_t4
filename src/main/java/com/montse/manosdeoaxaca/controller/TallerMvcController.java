package com.montse.manosdeoaxaca.controller;

import com.montse.manosdeoaxaca.dto.TallerDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mvc/talleres")
public class TallerMvcController {

    /*Lista temporarl*/
    private final List<TallerDTO> talleres = new ArrayList<>();

    /*Lee una propiedad desde application.properties.*/
    @Value("${proyecto.nombre}")
    private String nombreProyecto;

    public TallerMvcController() {

        talleres.add(new TallerDTO(
                1L,
                "Taller de Barro Negro",
                "María Hernández",
                "Alfarería",
                "San Bartolo Coyotepec"
        ));

        talleres.add(new TallerDTO(
                2L,
                "Alebrijes Hernández",
                "José Hernández",
                "Alebrijes",
                "San Martín Tilcajete"
        ));

        talleres.add(new TallerDTO(
                3L,
                "Textiles del Valle",
                "Ana Mendoza",
                "Textiles",
                "Teotitlán del Valle"
        ));

        talleres.add(new TallerDTO(
                4L,
                "Manos de Palma",
                "Carmen López",
                "Palma",
                "Región Mixteca"
        ));
    }

    /* Muestra todos los talleres.*/
    
    @GetMapping
    public String mostrarTalleres(
            @RequestParam(required = false) String especialidad,
            Model model) {

        List<TallerDTO> resultado;

        if (especialidad == null || especialidad.isBlank()) {
            resultado = talleres;
        } else {
            resultado = talleres.stream()
                    .filter(taller -> taller.getEspecialidad()
                            .equalsIgnoreCase(especialidad))
                    .toList();
        }

        model.addAttribute("talleres", resultado);
        model.addAttribute("especialidadSeleccionada", especialidad);
        model.addAttribute("nombreProyecto", nombreProyecto);

        return "talleres/lista";
    }

    /*Abre el formulario para crear un taller. */
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {

        model.addAttribute("taller", new TallerDTO());
        model.addAttribute("nombreProyecto", nombreProyecto);

        return "talleres/formulario";
    }

    /*Recibe los campos enviados desde el formulario.*/
    @PostMapping("/guardar")
    public String guardarTaller(
            @ModelAttribute("taller") TallerDTO taller) {

        long nuevoId = talleres.size() + 1L;
        taller.setId(nuevoId);

        talleres.add(taller);

        return "redirect:/mvc/talleres";
    }

    /* Muestra el detalle de un taller usando su ID.*/
  
    @GetMapping("/{id}")
    public String mostrarDetalle(
            @PathVariable Long id,
            Model model) {

        TallerDTO tallerEncontrado = talleres.stream()
                .filter(taller -> taller.getId().equals(id))
                .findFirst()
                .orElse(null);

        model.addAttribute("taller", tallerEncontrado);
        model.addAttribute("nombreProyecto", nombreProyecto);

        return "talleres/detalle";
    }
}