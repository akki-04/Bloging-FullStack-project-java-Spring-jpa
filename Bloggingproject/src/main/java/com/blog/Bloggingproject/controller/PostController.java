package com.blog.Bloggingproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.blog.Bloggingproject.model.Post;
import com.blog.Bloggingproject.repository.postRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class PostController {
    @Autowired
    postRepo p;


     @GetMapping("/")
    public String viewHome(Model model){
        model.addAttribute("listPosts",p.findAll());
        return "index";
    }

    @GetMapping("/new")    
    public String newPost(Model model){
        model.addAttribute("post", new Post());
        return "new_post";
    }

    @PostMapping("/save")
    
    public String savePost(@ModelAttribute("post") Post post){
        p.save(post);   
        return "redirect:/"; 
    }

    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable int id,Model model){
        model.addAttribute("post",p.findById(id));
        return "/edit_post";        
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("post") Post post){
        p.save(post);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable int id) {
       p.deleteById(id);
       return "redirect:/";
    }
    

}
