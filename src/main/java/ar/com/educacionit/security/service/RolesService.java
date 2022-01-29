package ar.com.educacionit.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.educacionit.domain.Roles;
import ar.com.educacionit.security.repository.RolesRepository;

@Service
@Transactional
public class RolesService {

    @Autowired
    RolesRepository rolesRepository;

    public Optional<Roles> getByRolNombre(String role){
        return rolesRepository.findByRole(role);
    }

    public void save(Roles rol){
        rolesRepository.save(rol);
    }
}
