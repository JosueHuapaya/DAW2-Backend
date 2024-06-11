package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.Usuario;

public interface PrestatarioService {
	public abstract Usuario insertaActualizaUsuario(Usuario obj);
	public abstract List<Usuario> listaUsuario();
	public abstract List<Usuario> listaUsuarioPorLoginIgual(String login);
	public abstract List<Usuario> listaUsuarioPorDniIgual(String dni);
}
