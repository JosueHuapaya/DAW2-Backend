package com.prestamo.service;

import com.prestamo.entity.Coordenada;
import com.prestamo.entity.MontoPrestamo;
import com.prestamo.entity.Usuario;

import java.math.BigDecimal;
import java.util.List;

public interface CoordenadaService {

    public List<Usuario> listaPrestamistariosTotales (Usuario usuario);
    public List<Coordenada> listarCoordenadas();
    public Coordenada agregarCoordenadas (Coordenada coordenada);
    public Coordenada actualizarCoordenadas (Coordenada coordenada);
    public abstract List<Coordenada> obtenerCoordenadasPorPrimerosDigitosLatitud(String latitudDigito);
    void eliminarCoordenada(int idCoordenada);
    public abstract List<Coordenada> consultaComplejaCoordenada(BigDecimal latitud, BigDecimal longitud, String departamento);


}
