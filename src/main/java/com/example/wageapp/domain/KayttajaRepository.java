package com.example.wageapp.domain;

import org.springframework.data.repository.CrudRepository;


public interface KayttajaRepository extends CrudRepository<Kayttaja, Long> {
Kayttaja findByusername(String username);
}

