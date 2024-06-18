package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.DataCatalogo;

public interface DataCatalogoService {
	public abstract List<DataCatalogo> listaDataCatalogo(int idTipo);
	public abstract DataCatalogo registrar(DataCatalogo dataCatalogo);
	public abstract List<DataCatalogo> listaDataCatalogoPorDescripcionIgual(String descripcion);

}
