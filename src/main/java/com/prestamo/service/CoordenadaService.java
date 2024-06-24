package com.prestamo.service;

import com.prestamo.entity.Coordenada;
import com.prestamo.entity.Usuario;

import java.util.List;

public interface CoordenadaService {

    public List<Usuario> listaPrestamistariosTotales (Usuario usuario);

    public Coordenada agregarCoordenadas (Coordenada coordenada);



}
