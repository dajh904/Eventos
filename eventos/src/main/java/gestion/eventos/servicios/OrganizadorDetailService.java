package gestion.eventos.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import gestion.eventos.entidades.Organizador;
import gestion.eventos.repositorios.OrganizadorRepository;

@Service
public class OrganizadorDetailService implements UserDetailsService {
    @Autowired
    private OrganizadorRepository organizadorRepo;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Optional<Organizador> organizador = organizadorRepo.findByCorreo(correo);
        if (organizador.isPresent()) {
            return User.builder()
                            .username(organizador.get().getNombre() + " " + organizador.get().getApellido())
                            .password(organizador.get().getContrasena())
                            .build();
        } else {
            throw new UsernameNotFoundException(correo);
        }
    }
}
