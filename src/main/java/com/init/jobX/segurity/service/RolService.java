package com.init.jobX.segurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.init.jobX.segurity.entity.Rol;
import com.init.jobX.segurity.enums.RolName;
import com.init.jobX.segurity.repository.RolRepository;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolName(RolName rolName){
        return rolRepository.findByRolName(rolName);
    }

    public Rol save(Rol rol){
        rolRepository.save(rol);
        return rol;
    }
}
