package com.arndtt.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import com.arndtt.dojosandninjas.models.Ninja;
import com.arndtt.dojosandninjas.repositories.NinjaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepository;
	
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
	
	public Ninja oneNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public Ninja updateNinja(Ninja ninja) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(ninja.getId());
		if(optionalNinja.isPresent()) {
			return ninjaRepository.save(ninja);
		} else {
			return null;
		}
	}
	
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
}
