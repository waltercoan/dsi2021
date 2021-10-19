package br.univille.walterdsi2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.walterdsi2021.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    //SELECT * FROM USUARIO WHERE USUARIO.USUARIO = "ZEZINHO"
    Usuario findByUsuario(String usuario);
    //SELECT * FROM USUARIO WHERE USUARIO.USUARIO = "ZEZINHO" AND USUARIO.SENHA = "123"
    Usuario findByUsuarioAndSenha(String usuario,String senha);
}
