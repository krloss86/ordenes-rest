package ar.com.educacionit.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.security.repository.UsersRepository;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsersRepository usersRepository;

    public Optional<Users> getByNombreUsuario(String nombreUsuario){
        return usersRepository.findByUsername(nombreUsuario);
    }

    public void save(Users usuario){
        usersRepository.save(usuario);
    }
}
