package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.MontoPrestamo;

public interface MontoPrestamoService {

	public abstract MontoPrestamo Registramontoprestamo(MontoPrestamo objmontoprestamo);
	
	public abstract List<MontoPrestamo> ListarMontoPrestamo();


	public abstract List<MontoPrestamo> ListaCapital(int capital);
	
	public abstract List<MontoPrestamo> ListaCapitalActualiza(int capital, int idMontoPrestamo);
	
	public abstract void eliminaMonto(int idMonto);
}
