package com.prestamo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.MontoPrestamo;
import com.prestamo.repository.MontoPrestamoRepository;

@Service
public class MontoPrestamoServiceImpl implements MontoPrestamoService{

	@Autowired
	private MontoPrestamoRepository repoMonto;
	
	@Override
	public MontoPrestamo Registramontoprestamo(MontoPrestamo objmontoprestamo) {
		// TODO Auto-generated method stub
		return repoMonto.save(objmontoprestamo);
	}

	@Override
	public List<MontoPrestamo> ListarMontoPrestamo() {
		// TODO Auto-generated method stub
		return repoMonto.findAll();
	}

	@Override
	public List<MontoPrestamo> ListaCapital(int capital) {
		// TODO Auto-generated method stub
		return repoMonto.ListarPorCapital(capital);
	}

	@Override
	public List<MontoPrestamo> ListaCapitalActualiza(int capital, int idMontoPrestamo) {
		// TODO Auto-generated method stub
		return repoMonto.ListarPorCapitalIgualActualiza(capital, idMontoPrestamo) ;
	}

	@Override
	public void eliminaMonto(int idMonto) {
		// TODO Auto-generated method stub
		repoMonto.deleteById(idMonto);
	}

	@Override
	public List<MontoPrestamo> listaMontoPrestamosConsultaCompleja(int capital, int dias, BigDecimal monto,
			int estado) {
		// TODO Auto-generated method stub
		return repoMonto.listaMontoPrestamosConsultaCompleja(capital, dias, monto, estado);
	}

	
	
}
