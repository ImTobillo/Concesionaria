package com.tobillo.concesionaria.Concesionaria.controller;

import com.tobillo.concesionaria.Concesionaria.model.Vehiculo;
import com.tobillo.concesionaria.Concesionaria.services.VehiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    VehiculoService vehiculoService;

    @Autowired
    public VehiculoController (VehiculoService vehiculoService)
    {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public List<Vehiculo> obtenerVehiculos()
    {
        return vehiculoService.obtenerVehiculos();
    }

    @GetMapping("/{id}")
    public Vehiculo buscarPorId(@PathVariable int id) {
        return vehiculoService.buscarPorId(id);
    }

    @PostMapping
    public Vehiculo crearVehiculo(@Valid @RequestBody Vehiculo nuevoVehiculo)
    {
        return vehiculoService.crearVehiculo(nuevoVehiculo);
    }

    @PutMapping("/{id}")
    public Vehiculo actualizarVehiculo(
            @PathVariable int id,
            @RequestBody Vehiculo vehiculoActualizado
    ){
        return vehiculoService.actualizarVehiculo(id, vehiculoActualizado);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarVehiculo(@PathVariable int id)
    {
        return eliminarVehiculo(id);
    }
}
