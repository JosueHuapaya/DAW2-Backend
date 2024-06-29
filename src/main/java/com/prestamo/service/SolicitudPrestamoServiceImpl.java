package com.prestamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.SolicitudPrestamo;
import com.prestamo.entity.Usuario;
import com.prestamo.repository.SolicitudPrestamoRepository;

@Service
public class SolicitudPrestamoServiceImpl implements SolicitudPrestamoService {

	@Autowired
	private SolicitudPrestamoRepository repository;
	
	@Override
	public SolicitudPrestamo insertaActualizaSolicitudPrestamo(SolicitudPrestamo obj) {
		return repository.save(obj);
	}

	@Override
	public List<SolicitudPrestamo> listaSolicitudPrestamo() {
		return repository.findAll();
	}

	@Override
	public void eliminaSolicitudPrestamo(int idSolicitudPrestamo) {
		repository.deleteById(idSolicitudPrestamo);		
	}
	
	@Override
    public List<Usuario> listaPrestatariosTotales(Usuario usuario) {
        return repository.listaPrestatariosTotales();
    }
}
