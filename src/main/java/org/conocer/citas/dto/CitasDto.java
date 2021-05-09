package org.conocer.citas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CitasDto {

    @JsonProperty("encabezado")
    private String encabezado;

    @JsonProperty("ubicacion")
    private String ubicacion;

    @JsonProperty("fechaInicio")
    private String fechaInicio;

    @JsonProperty("fechaFin")
    private String fechaFin;

    @JsonProperty("email")
    private String email;

    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("empresa")
    private String empresa;

    @JsonProperty("ocupacion")
    private String ocupacion;

    @JsonProperty("fecha")
    private Date fecha;

    @JsonProperty("horario")
    private String horario;

    @JsonProperty("entidad")
    private String entidad;

    @JsonProperty("medios")
    private String medio;


    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }
}
