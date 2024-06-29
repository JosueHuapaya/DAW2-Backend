package com.prestamo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prestamo.entity.SolicitudPrestamo;
import com.prestamo.entity.Usuario;

public interface SolicitudPrestamoRepository extends JpaRepository<SolicitudPrestamo, Integer> {
	
	@Query("Select r from Usuario r, UsuarioHasRol u where r.idUsuario = u.usuario.idUsuario and u.rol.idRol = 4 order by r.apellidos desc ")
    public abstract List<Usuario> listaPrestatariosTotales();
}
