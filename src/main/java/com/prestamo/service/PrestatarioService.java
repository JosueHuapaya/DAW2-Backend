package com.prestamo.service;

import java.util.List;


import org.springframework.data.repository.query.Param;

import com.prestamo.entity.Usuario;

public interface PrestatarioService {
	public abstract Usuario insertaActualizaUsuario(Usuario obj);
	public abstract List<Usuario> listaUsuario();
	public abstract List<Usuario> listaUsuarioPorLoginIgual(String login);
	public abstract List<Usuario> listaUsuarioPorDniIgual(String dni);

	//T2
	public abstract void eliminarUsuario(int idUsuario);
	public abstract List<Usuario> usuarioPorDniIgualActu(String dni, int idUsuario);
	public abstract List<Usuario> usuarioPorLoginIgualActu(String login, int idUsuario);
	public abstract List<Usuario> listaUsuarioPorLogin(String login);
	public abstract List<Usuario> prestatariosDeUnPrestamista(int idUsuario, String login);
	public abstract List<Usuario> listarPrestatariosDeUnPrestamista(int idUsuario);
	public void deleteUsuario(@Param("idUsuario") int idUsuario);
	
	//EF
	public abstract List<Usuario> consultaPrestatarioCompleja(String nombres, String apellidos,String dni, String direccion);
}
