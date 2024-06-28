package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.DataCatalogo;
import com.prestamo.entity.Ejemplo;

public interface DataCatalogoService {
	public abstract List<DataCatalogo> listaDataCatalogo(int idTipo);
	public abstract List<DataCatalogo> listaDataCatalogoPorDescripcionIgual(String descripcion);
	public abstract  List<DataCatalogo> listaDataCatalogoPorDescripcionIgualActualizar(String descripcion, int id);
	public abstract List<DataCatalogo> listaDataCatalogoPorDescripcionLike(String nombre);

	//CRUD
	public abstract DataCatalogo registrar(DataCatalogo dataCatalogo);
	public abstract void eliminarDataCatalogo(int id);
	public abstract List<DataCatalogo> listaDataCatalogo();

	//consulta
	public abstract  List<DataCatalogo> listaConsultaComplejaDataCatalogo(String descripcion, int estado, int idCatalogo);
}
