package br.univille.walterdsi2021.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.walterdsi2021.model.Post;
import br.univille.walterdsi2021.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
    
    @Autowired
    private PostService service;

    @GetMapping
    public ModelAndView index(){
        HashMap<String,Object> dados = new HashMap<>();
        List<Post> listaPosts = service.getAll();
        dados.put("listaPosts", listaPosts);
        dados.put("post", new Post());
        return new ModelAndView("post/index", dados);    
    }

    @PostMapping(params="form")
    public ModelAndView save(Post post){
        post.setDataPost(new Date());
        service.save(post);
        return new ModelAndView("redirect:/post");
    }

}
