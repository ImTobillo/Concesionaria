package com.tobillo.concesionaria.Concesionaria.model;

import com.tobillo.concesionaria.Concesionaria.controller.VehiculoController;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Vehiculo {
    private int id;
    @NotNull(message = "Debe existir una marca")
    private String marca;
    @NotNull(message = "Debe existir un modelo")
    private String modelo;
    @NotNull(message = "Debe existir una patente")
    @Size(min = 6, max = 7)
    private String patente;
    @NotNull(message = "Debe existir un año")
    @Min(1930)
    @Max(2024)
    private int anio;

    public Vehiculo(int id, String marca, String modelo, String patente, int anio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.anio = anio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }


}
