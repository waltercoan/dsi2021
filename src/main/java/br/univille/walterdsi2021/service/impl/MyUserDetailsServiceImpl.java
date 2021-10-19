package br.univille.walterdsi2021.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import java.util.ArrayList;

import br.univille.walterdsi2021.model.Usuario;
import br.univille.walterdsi2021.repository.UsuarioRepository;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario buscaUsuarioSenha(String nomeUsuario, String senhaUsuario){
        return repository.findByUsuarioAndSenha(nomeUsuario, senhaUsuario);
    }
  

    @Override
    public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
        Usuario usuario = repository.findByUsuario(nomeUsuario);
        return new User(usuario.getUsuario(),usuario.getSenha(), new ArrayList<>());
    }  
    
}
