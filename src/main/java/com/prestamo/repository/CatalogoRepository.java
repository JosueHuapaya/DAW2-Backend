package com.prestamo.repository;

import com.prestamo.entity.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CatalogoRepository extends JpaRepository<Catalogo,Integer> {
}
