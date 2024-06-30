package com.prestamo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prestamo.entity.MontoPrestamo;

public interface MontoPrestamoRepository extends JpaRepository <MontoPrestamo, Integer> {

	@Query("select m from MontoPrestamo m where m.capital = ?1")
	public abstract List<MontoPrestamo> ListarPorCapital(int capital);
	
	
	@Query("select m from MontoPrestamo m where m.capital = ?1 and m.idMontoPrestamo != ?2 ")
	public abstract List<MontoPrestamo> ListarPorCapitalIgualActualiza(int capital, int idMontoPrestamo);
	
	@Query("select m from MontoPrestamo m where m.capital = ?1 and"
			+"( ?2 = -1 or m.dias.idDataCatalogo = ?2 ) and "
			+" m.monto = ?3 and "
			+" m.estado = ?4 ")
	public abstract List<MontoPrestamo> listaMontoPrestamosConsultaCompleja(int capital, int dias, BigDecimal monto, int estado);
}
