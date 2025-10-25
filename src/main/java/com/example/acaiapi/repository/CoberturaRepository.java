package com.example.acaiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.acaiapi.model.Cobertura;;

@Repository
public interface CoberturaRepository extends JpaRepository<Cobertura, Long> {
}
