package com.arndtt.dojosandninjas.repositories;

import java.util.List;

import com.arndtt.dojosandninjas.models.Dojo;

import org.springframework.data.repository.CrudRepository;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();

}
