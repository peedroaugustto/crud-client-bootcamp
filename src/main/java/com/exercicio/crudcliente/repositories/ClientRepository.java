package com.exercicio.crudcliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercicio.crudcliente.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
