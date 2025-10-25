package com.example.acaiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.acaiapi.model.Complementos;

@Repository
public interface ComplementosRepository extends JpaRepository<Complementos, Long> {
	
}
