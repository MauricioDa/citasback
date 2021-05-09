package org.conocer.citas.dto;

import org.conocer.citas.model.Catalogo;

import java.util.List;

public class CatalogosResponseDto {

    List<Catalogo> horarios;

    List<Catalogo> entidades;

    List<Catalogo> medios;

    List<Catalogo> ocupacion;

    public CatalogosResponseDto(List<Catalogo> horarios, List<Catalogo> entidades, List<Catalogo> medios, List<Catalogo> ocupacion) {
        this.horarios = horarios;
        this.entidades = entidades;
        this.medios = medios;
        this.ocupacion = ocupacion;
    }

    public List<Catalogo> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Catalogo> horarios) {
        this.horarios = horarios;
    }

    public List<Catalogo> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Catalogo> entidades) {
        this.entidades = entidades;
    }

    public List<Catalogo> getMedios() {
        return medios;
    }

    public void setMedios(List<Catalogo> medios) {
        this.medios = medios;
    }

    public List<Catalogo> getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(List<Catalogo> ocupacion) {
        this.ocupacion = ocupacion;
    }
}
