package com.prestamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.MontoPrestamo;
import com.prestamo.repository.MontoPrestamoRepository;

@Service
public class MontoPrestamoServiceImpl implements MontoPrestamoService{

	@Autowired
	private MontoPrestamoRepository monto;
	
	
	@Override
	public MontoPrestamo Registramontoprestamo(MontoPrestamo objmontoprestamo) {
		// TODO Auto-generated method stub
		return monto.save(objmontoprestamo);
	}

	@Override
	public List<MontoPrestamo> ListarMontoPrestamo() {
		// TODO Auto-generated method stub
		return monto.findAll();
	}

	@Override
	public List<MontoPrestamo> ListaCapital(int capital) {
		// TODO Auto-generated method stub
		return monto.ListarPorCapital(capital);
	}

	@Override
	public List<MontoPrestamo> ListaCapitalActualiza(int capital, int idMontoPrestamo) {
		// TODO Auto-generated method stub
		return monto.ListarPorCapitalIgualActualiza(capital, idMontoPrestamo) ;
	}

	@Override
	public void eliminaMonto(int idMonto) {
		// TODO Auto-generated method stub
		monto.deleteById(idMonto);
	}

	
	
}
