package com.prestamo.service;

import com.prestamo.entity.Coordenada;

import java.util.List;

public interface CoordenadaService {

    List<Coordenada> findAll();

    public Coordenada agregarCoordenadas (Coordenada coordenada);

}
