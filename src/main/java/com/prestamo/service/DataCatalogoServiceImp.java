package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.Catalogo;
import com.prestamo.entity.Ejemplo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.DataCatalogo;
import com.prestamo.repository.DataCatalogoRepository;

@Service
public class DataCatalogoServiceImp implements DataCatalogoService {
	@Autowired
	private DataCatalogoRepository repository;
	@Override
	public List<DataCatalogo> listaDataCatalogo(int idTipo) {
		return repository.listaDataCatalogo(idTipo);
	}
	@Override
	public DataCatalogo registrar(DataCatalogo dataCatalogo) {
		return repository.save(dataCatalogo);
	}

	@Override
	public List<DataCatalogo> listaDataCatalogoPorDescripcionIgual(String descripcion) {
		return repository.listaDataCatalogoPorDescripcionIgual(descripcion);
	}


}
