package com.prestamo.repository;

import com.prestamo.entity.Coordenada;
import com.prestamo.entity.MontoPrestamo;
import com.prestamo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CoordenadaRepository  extends JpaRepository<Coordenada, Integer> {

    @Query("Select r from Usuario r, UsuarioHasRol u where r.idUsuario = u.usuario.idUsuario and u.rol.idRol = 4 order by r.apellidos desc ")
    public abstract List<Usuario> listaPrestamistariosTotales();

    @Query("SELECT r FROM Coordenada r WHERE CAST(r.latitud AS string) LIKE CONCAT(?1, '%')")
    List<Coordenada> obtenerCoordenadasPorPrimerosDigitosLatitud(String latitudDigito);

    @Query("SELECT c FROM Coordenada c " + "WHERE (:latitud = 0 or c.latitud = :latitud) " + "AND (:longitud = 0 or c.longitud = :longitud )" +"AND ( :departamento= '' or c.ubigeo.departamento = :departamento)")
    List<Coordenada> consultaComplejaCoordenada(BigDecimal latitud, BigDecimal longitud, String departamento);

}