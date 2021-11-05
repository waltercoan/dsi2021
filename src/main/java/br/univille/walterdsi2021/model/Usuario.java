package br.univille.walterdsi2021.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String usuario;
    private String senha;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<Papel> listaPapeis = new ArrayList<Papel>();

    @Temporal(value = TemporalType.DATE)
    private Date data;

    public Collection<? extends GrantedAuthority> getAuthorities(){
        List<Papel> papeis = getListaPapeis();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Papel papel : papeis){
            authorities.add(new SimpleGrantedAuthority(papel.getDescricao()));
        }
        return authorities;
    }

    public List<Papel> getListaPapeis() {
        return listaPapeis;
    }
    public void setListaPapeis(List<Papel> listaPapeis) {
        this.listaPapeis = listaPapeis;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
