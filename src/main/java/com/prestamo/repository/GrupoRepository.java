package com.prestamo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prestamo.entity.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {

	@Query("select e from Grupo e where e.descripcion = ?1")
	public abstract List<Grupo> listaGrupoPorDescripcionIgual(String descripcion);
}
