package com.prestamo.repository;

import com.prestamo.entity.Coordenada;
import com.prestamo.entity.MontoPrestamo;
import com.prestamo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface CoordenadaRepository  extends JpaRepository<Coordenada, Integer> {

    @Query("Select r from Usuario r, UsuarioHasRol u where r.idUsuario = u.usuario.idUsuario and u.rol.idRol = 4 order by r.apellidos desc ")
    public abstract List<Usuario> listaPrestamistariosTotales();

    @Query("SELECT r FROM Coordenada r WHERE CAST(r.latitud AS string) LIKE CONCAT(?1, '%')")
    List<Coordenada> obtenerCoordenadasPorPrimerosDigitosLatitud(String latitudDigito);

}
