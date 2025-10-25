package com.example.acaiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.acaiapi.model.Frutas;

@Repository
public interface FrutasRepository extends JpaRepository<Frutas, Long> {
	
}
