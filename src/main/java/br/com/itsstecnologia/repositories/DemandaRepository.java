package br.com.itsstecnologia.repositories;


import Model.Demanda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandaRepository extends JpaRepository<Demanda, Integer> { }
