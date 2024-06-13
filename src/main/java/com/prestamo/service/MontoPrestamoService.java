package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.MontoPrestamo;

public interface MontoPrestamoService {

	public abstract MontoPrestamo Registramontoprestamo(MontoPrestamo objmontoprestamo);
	
	public abstract List<MontoPrestamo> ListarMontoPrestamo();

	
}
