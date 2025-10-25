package com.example.acaiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.acaiapi.model.ComplementosPremium;

@Repository
public interface ComplementosPremiumRepository extends JpaRepository<ComplementosPremium, Long> {
	
}
