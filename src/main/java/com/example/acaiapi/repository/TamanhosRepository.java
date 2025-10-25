package com.example.acaiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.acaiapi.model.Tamanhos;

@Repository
public interface TamanhosRepository extends JpaRepository<Tamanhos, Long> {
	
}
