package br.univille.walterdsi2021;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.walterdsi2021.model.Papel;
import br.univille.walterdsi2021.model.Usuario;
import br.univille.walterdsi2021.repository.PapelRepository;
import br.univille.walterdsi2021.repository.UsuarioRepository;
import br.univille.walterdsi2021.service.PapelService;

@Component
public class Startup {
    
    @Autowired
    private PapelRepository papelRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
        if(papelRepository.findByDescricao("ADMIN") == null) {
			Papel papel = new Papel();
			papel.setDescricao("ADMIN");
			papelRepository.save(papel);
		}
        if(papelRepository.findByDescricao("ATENDENTE") == null) {
			Papel papel = new Papel();
			papel.setDescricao("ATENDENTE");
			papelRepository.save(papel);
		}
        Usuario usuario = usuarioRepository.findByUsuario("admin");
        if( usuario == null) {
            usuario = new Usuario();
            usuario.setUsuario("admin");
            usuario.setSenha("admin");
        }
        Papel papelAdmin = papelRepository.findByDescricao("ADMIN");
        if(usuario.getListaPapeis().size() == 0)
            usuario.getListaPapeis().add(papelAdmin);
        usuarioRepository.save(usuario);

        usuario = usuarioRepository.findByUsuario("zezinho");
        if( usuario == null) {
            usuario = new Usuario();
            usuario.setUsuario("zezinho");
            usuario.setSenha("zezinho");
        }
        Papel papelAtendente = papelRepository.findByDescricao("ATENDENTE");
        if(usuario.getListaPapeis().size() == 0)
            usuario.getListaPapeis().add(papelAtendente);
        usuarioRepository.save(usuario);


        
    }
}
