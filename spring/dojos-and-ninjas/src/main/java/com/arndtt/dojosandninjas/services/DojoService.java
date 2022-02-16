package com.arndtt.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import com.arndtt.dojosandninjas.models.Dojo;
import com.arndtt.dojosandninjas.repositories.DojoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepository;

	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}

	public Dojo oneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()){
			return optionalDojo.get();
		} else {
			return null;
		}
	}

	public Dojo create(Dojo dojo) {
		return dojoRepository.save(dojo);
	}

	public Dojo updateDojo(Dojo dojo) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(dojo.getId());
		if(optionalDojo.isPresent()) {
			return dojoRepository.save(dojo);
		} else {
			return null;
		}
	}

	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
}
