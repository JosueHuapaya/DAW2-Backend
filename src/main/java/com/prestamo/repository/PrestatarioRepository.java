package com.prestamo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prestamo.entity.Usuario;

public interface PrestatarioRepository extends JpaRepository<Usuario, Integer>{
	@Query("select u from Usuario u where u.login = ?1")
	public abstract List<Usuario> listaUsuarioPorLoginIgual(String login);
	
	@Query("select u from Usuario u where u.dni = ?1")
	public abstract List<Usuario> listaUsuarioPorDniIgual(String dni);
	
	//T2
	@Query("select u from Usuario u where u.login like ?1")
	public abstract List<Usuario> listaUsuarioPorLogin(String login);
	
	@Query("Select r from Usuario r, UsuarioHasRol u where r.idUsuario = u.usuario.idUsuario and u.rol.idRol = 4 and r.usuarioSuperior =?1 and r.login like ?2")
	public abstract List<Usuario> prestatariosDeUnPrestamista(int idUsuario, String login);
	
	@Query("select u from Usuario u where u.login = ?1 and u.idUsuario != ?2")
	public abstract List<Usuario> usuarioPorLoginIgualActu(String login, int idUsuario);
	
	@Query("select u from Usuario u where u.dni = ?1 and u.idUsuario != ?2")
	public abstract List<Usuario> usuarioPorDniIgualActu(String dni, int idUsuario);

	@Query("Select u from Usuario u where u.usuarioSuperior =?1")
	public abstract List<Usuario> listarPrestatariosDeUnPrestamista(int idUsuario);

}
