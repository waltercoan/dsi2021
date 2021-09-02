package br.univille.walterdsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.walterdsi2021.model.Post;
import br.univille.walterdsi2021.repository.PostRepository;
import br.univille.walterdsi2021.service.PostService;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository repository;

    @Override
    public List<Post> getAll() {
        return repository.findAllTopTenOrderByDataPostDesc();
    }

    @Override
    public void save(Post post) {
        repository.save(post);
    }
}
