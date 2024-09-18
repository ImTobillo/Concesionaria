package com.tobillo.concesionaria.Concesionaria.controller;

import com.tobillo.concesionaria.Concesionaria.model.Vehiculo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    private final List<Vehiculo> listaVehiculos = new ArrayList<>();

    public VehiculoController ()
    {
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

    @GetMapping("{/id}")
    public Vehiculo buscarPorId(@PathVariable int id) {
        return listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


}
