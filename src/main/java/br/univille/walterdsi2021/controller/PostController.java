package br.univille.walterdsi2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<Post> listaPosts = service.getAll();
        return new ModelAndView("post/index", "listaPosts", listaPosts);    
    }

}
