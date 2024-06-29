package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.SolicitudPrestamo;
import com.prestamo.entity.Usuario;

public interface SolicitudPrestamoService {

	//Para el crud
	public abstract SolicitudPrestamo insertaActualizaSolicitudPrestamo(SolicitudPrestamo obj);
	public abstract List<SolicitudPrestamo> listaSolicitudPrestamo();
	public abstract void eliminaSolicitudPrestamo(int idSolicitudPrestamo);
	
	//Para el combo
	public abstract List<Usuario> listaPrestatariosTotales(Usuario usuario);
}
