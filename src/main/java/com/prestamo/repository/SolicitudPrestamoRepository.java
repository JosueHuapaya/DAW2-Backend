package com.prestamo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prestamo.entity.SolicitudPrestamo;
import com.prestamo.entity.Usuario;

public interface SolicitudPrestamoRepository extends JpaRepository<SolicitudPrestamo, Integer> {
	
	@Query("Select r from Usuario r, UsuarioHasRol u where r.idUsuario = u.usuario.idUsuario and u.rol.idRol = 4 order by r.apellidos desc ")
    public abstract List<Usuario> listaPrestatariosTotales();
	
	@Query("SELECT s FROM SolicitudPrestamo s JOIN FETCH s.usuarioRegistro WHERE s.capital < :capital")
    public abstract List<SolicitudPrestamo> listaSolicitudPrestamoPorCapitalMenorQueLike(@Param("capital") Double capital);
	
	@Query("SELECT s FROM SolicitudPrestamo s WHERE "
	         + "(:capital IS NULL OR s.capital = :capital) AND "
	         + "(:dias IS NULL OR s.dias.idDataCatalogo = :dias) AND "
	         + "(:montoPagar IS NULL OR s.montoPagar = :montoPagar) AND "
	         + "(:fechaInicio IS NULL OR s.fechaInicioPrestamo >= :fechaInicio) AND "
	         + "(:fechaFin IS NULL OR s.fechaFinPrestamo <= :fechaFin) AND "
	         + "(:estadoSolicitud IS NULL OR s.estadoSolicitud.idDataCatalogo = :estadoSolicitud) AND "
	         + "(:prestatario IS NULL OR s.usuarioPrestatario.idUsuario = :prestatario)")
	public abstract List<SolicitudPrestamo> consultaCompleja(
	        @Param("capital") Double capital,
	        @Param("dias") Integer dias,
	        @Param("montoPagar") Double montoPagar,
	        @Param("fechaInicio") String fechaInicio,
	        @Param("fechaFin") String fechaFin,
	        @Param("estadoSolicitud") Integer estadoSolicitud,
	        @Param("prestatario") Integer prestatario);
}
