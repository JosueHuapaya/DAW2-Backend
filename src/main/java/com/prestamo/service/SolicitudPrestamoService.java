package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.SolicitudPrestamo;
import com.prestamo.entity.Usuario;

public interface SolicitudPrestamoService {
	public abstract List<SolicitudPrestamo> listaSolicitudPrestamoPorCapitalMenorQueLike(String capital);

	//Para el crud
	public abstract SolicitudPrestamo insertaActualizaSolicitudPrestamo(SolicitudPrestamo obj);
	public abstract List<SolicitudPrestamo> listaSolicitudPrestamo();
	public abstract void eliminaSolicitudPrestamo(int idSolicitudPrestamo);
	
	//Para el combo
	public abstract List<Usuario> listaPrestatariosTotales(Usuario usuario);
	
	//Para la consulta
	public abstract List<SolicitudPrestamo> consultaCompleja(
            Double capital, Integer dias, Double montoPagar,
            String fechaInicio, String fechaFin, Integer estadoSolicitud, Integer prestatario);
}
