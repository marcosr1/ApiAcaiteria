package com.example.acaiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.acaiapi.model.Cremes;

@Repository
public interface CremesRepository extends JpaRepository<Cremes, Long> {

}
