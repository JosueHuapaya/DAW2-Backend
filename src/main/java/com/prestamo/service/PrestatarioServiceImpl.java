package com.prestamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.Usuario;
import com.prestamo.entity.UsuarioHasRol;
import com.prestamo.entity.UsuarioHasRolPK;
import com.prestamo.repository.PrestatarioRepository;
import com.prestamo.repository.UsuarioTieneRolRepository;

import jakarta.transaction.Transactional;

@Service
public class PrestatarioServiceImpl implements PrestatarioService{
	
	@Autowired
	private PrestatarioRepository prestatarioRepository;
	
	@Autowired
	private UsuarioTieneRolRepository usuarioTieneRolRepository;
	

	@Override
	@Transactional
	public Usuario insertaActualizaUsuario(Usuario obj) {
		
		Usuario objUsuario = prestatarioRepository.save(obj);
		
		UsuarioHasRolPK usuarioHasRolPK = new UsuarioHasRolPK();
		usuarioHasRolPK.setIdRol(4);
		usuarioHasRolPK.setIdUsuario(objUsuario.getIdUsuario());
		
		UsuarioHasRol objUsuarioHasRol = new UsuarioHasRol();
		objUsuarioHasRol.setUsuarioHasRolPk(usuarioHasRolPK);
		
		usuarioTieneRolRepository.save(objUsuarioHasRol);
		
		return objUsuario;
	}

	@Override
	public List<Usuario> listaUsuario() {
		return prestatarioRepository.findAll();
	}

	@Override
	public List<Usuario> listaUsuarioPorLoginIgual(String login) {
		return prestatarioRepository.listaUsuarioPorLoginIgual(login);
	}

	@Override
	public List<Usuario> listaUsuarioPorDniIgual(String dni) {
		return prestatarioRepository.listaUsuarioPorDniIgual(dni);
	}
	
}
