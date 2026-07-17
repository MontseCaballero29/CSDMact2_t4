package com.montse.manosdeoaxaca.dto;

public class TallerDTO {

    private Long id;
    private String nombreTaller;
    private String artesano;
    private String especialidad;
    private String ubicacion;

    /*
     * Constructor vacío.
     * Spring lo necesita para crear el objeto cuando recibe
     * información desde un formulario o desde una petición JSON.
     */
    public TallerDTO() {
    }

    /*
     * Constructor con todos los atributos.
     * Nos permitirá crear talleres fácilmente desde el controlador.
     */
    public TallerDTO(
            Long id,
            String nombreTaller,
            String artesano,
            String especialidad,
            String ubicacion) {

        this.id = id;
        this.nombreTaller = nombreTaller;
        this.artesano = artesano;
        this.especialidad = especialidad;
        this.ubicacion = ubicacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreTaller() {
        return nombreTaller;
    }

    public void setNombreTaller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
    }

    public String getArtesano() {
        return artesano;
    }

    public void setArtesano(String artesano) {
        this.artesano = artesano;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "TallerDTO{" +
                "id=" + id +
                ", nombreTaller='" + nombreTaller + '\'' +
                ", artesano='" + artesano + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}