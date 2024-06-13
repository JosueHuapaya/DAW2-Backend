package com.prestamo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prestamo.entity.MontoPrestamo;

public interface MontoPrestamoRepository extends JpaRepository <MontoPrestamo, Integer> {

	
}
