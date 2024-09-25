package com.tobillo.concesionaria.Concesionaria.services;

import com.tobillo.concesionaria.Concesionaria.model.Vehiculo;
import com.tobillo.concesionaria.Concesionaria.utils.Utilidades;
import com.tobillo.concesionaria.Concesionaria.utils.log.Log;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class VehiculoService {
    private final List<Vehiculo> listaVehiculos = new ArrayList<>();
    private final Utilidades utilidades;
    private final Log log;

    @Autowired
    public VehiculoService(Utilidades utilidades, @Qualifier("consoleLog") Log logService)
    {
        this.utilidades = utilidades;
        this.log = logService;
        listaVehiculos.add(new Vehiculo(1, "Peugeot", "307", "GDS213", 2008));
        listaVehiculos.add(new Vehiculo(2, "Ford", "Ranger", "SFD324", 2003));
        listaVehiculos.add(new Vehiculo(3, "Ford", "Taunus", "ASG232", 1989));
        listaVehiculos.add(new Vehiculo(4, "Chevrolet", "S10", "GSA321", 1999));
        listaVehiculos.add(new Vehiculo(5, "Fiat", "Siena", "SAA211", 2006));
    }

    @GetMapping
    public List<Vehiculo> obtenerVehiculos()
    {
        return listaVehiculos;
    }

    @GetMapping("/{id}")
    public Vehiculo buscarPorId(@PathVariable int id) {
        return listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Vehiculo crearVehiculo(
            @Valid @RequestBody Vehiculo nuevoVehiculo)
    {
        listaVehiculos.add(nuevoVehiculo);
        return nuevoVehiculo;
    }

    @PutMapping("/{id}")
    public Vehiculo actualizarVehiculo(
            @PathVariable int id,
            @RequestBody Vehiculo vehiculoActualizado
    ){
        Vehiculo vehiculoExistente = listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (vehiculoExistente != null)
        {
            vehiculoExistente.setAnio(vehiculoActualizado.getAnio());
            vehiculoExistente.setMarca(vehiculoActualizado.getMarca());
            vehiculoExistente.setModelo(vehiculoActualizado.getModelo());
            vehiculoExistente.setPatente(vehiculoActualizado.getPatente());
        }

        return vehiculoExistente;
    }

    @DeleteMapping("/{id}")
    public boolean eliminarVehiculo(@PathVariable int id)
    {
        return listaVehiculos.removeIf(vehiculo -> vehiculo.getId().equals(id));
    }
}
