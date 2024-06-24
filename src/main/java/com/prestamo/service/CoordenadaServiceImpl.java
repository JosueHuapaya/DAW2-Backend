package com.prestamo.service;

import com.prestamo.entity.Coordenada;
import com.prestamo.entity.Usuario;
import com.prestamo.repository.CoordenadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class CoordenadaServiceImpl implements CoordenadaService {

    @Autowired

    private CoordenadaRepository coordenadaRepository;

    @Override
    public List<Usuario> listaPrestamistariosTotales(Usuario usuario) {

        return coordenadaRepository.listaPrestamistariosTotales();

    }

    @Override
    public Coordenada agregarCoordenadas(Coordenada coordenada) {

        return coordenadaRepository.save(coordenada);

    }
}
