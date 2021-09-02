package br.univille.walterdsi2021.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.walterdsi2021.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>{
    List<Post> findAllTopTenByOrderByDataPostDesc();
}
