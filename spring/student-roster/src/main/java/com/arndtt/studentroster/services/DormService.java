package com.arndtt.studentroster.services;

import java.util.List;
import java.util.Optional;

import com.arndtt.studentroster.models.Dorm;
import com.arndtt.studentroster.repositories.DormRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DormService {
    
    @Autowired
    private DormRepository dormRepository;

    public List<Dorm> findAllDorms() {
        return dormRepository.findAll();
    }

    public Dorm oneDorm(Long id) {
        Optional<Dorm> optionalDorm = dormRepository.findById(id);
        if(optionalDorm.isPresent()) {
            return optionalDorm.get();
        } else {
            return null;
        }
    }

    public Dorm createDorm(Dorm dorm) {
        return dormRepository.save(dorm);
    }

    public Dorm updateDorm(Dorm dorm) {
        Optional<Dorm> optionalDorm = dormRepository.findById(dorm.getId());
        if(optionalDorm.isPresent()) {
            return dormRepository.save(dorm);
        } else {
            return null;
        }
    }

    public void deleteDorm(Long id) {
        dormRepository.deleteById(id);
    }

}
