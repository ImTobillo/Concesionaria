package com.tobillo.concesionaria.Concesionaria.controller;

import com.tobillo.concesionaria.Concesionaria.model.Vehiculo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    private final ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

    public VehiculoController ()
    {
        listaVehiculos.add(new Vehiculo("Peugeot", "307", "GDS213", 2008));
        listaVehiculos.add(new Vehiculo("Ford", "Ranger", "SFD324", 2003));
        listaVehiculos.add(new Vehiculo("Ford", "Taunus", "ASG232", 1989));
        listaVehiculos.add(new Vehiculo("Chevrolet", "S10", "GSA321", 1999));
        listaVehiculos.add(new Vehiculo("Fiat", "Siena", "SAA211", 2006));
    }

    @GetMapping
    public ArrayList<Vehiculo> obtenerVehiculos()
    {
        return listaVehiculos;
    }

}
