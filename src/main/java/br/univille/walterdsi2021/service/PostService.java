package br.univille.walterdsi2021.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.walterdsi2021.model.Post;

@Service
public interface PostService {
    public List<Post> getAll();
    public void save(Post post);
}
