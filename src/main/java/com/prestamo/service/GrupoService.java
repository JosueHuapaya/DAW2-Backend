package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.Grupo;

public interface GrupoService {

	public abstract List<Grupo> listaGrupoPorDescripcionIgual(String descripcion);
	public abstract List<Grupo> listaGrupoPorDescripcionIgualActualiza(String descripcion, int idEjemplo);
	
	
		//Para el crud
		public abstract Grupo InsertaActualizaGrupo(Grupo obj);
		public abstract List<Grupo> listaGrupoPorDescripcionLike(String nombre);
		public abstract void eliminaGrupo(int idGrupo);
		public abstract List<Grupo> listaGrupo();
}
