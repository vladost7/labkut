package com.boots.controller;

import com.boots.entity.Post;
import com.boots.entity.User;
import com.boots.service.PostService;
import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/post")
    public String postList(Model model){
        model.addAttribute("allPosts", postService.allPosts());
        return "posts";
    }

    @GetMapping("/postAdmin")
    public String postListAdmin(Model model){
        model.addAttribute("allPosts", postService.allPosts());
        return "adminPosts";
    }

    @PostMapping("/postAdmin")
    public String  deletePost(@RequestParam(required = true, defaultValue = "" ) Long postId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            postService.deletePost(postId);
        }
        return "redirect:/postAdmin";
    }

    @PostMapping("/changePostAdmin")
    public String  changePost(@RequestParam(required = true, defaultValue = "" ) Long postId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("change")){
            Post post = postService.findPost(postId);
            model.addAttribute("postForm", post);
            return "changePost";
        }
        return "redirect:/postAdmin";
    }

    @PostMapping("/postAdminChange")
    public String updatePost(@ModelAttribute("postForm")  Post postForm, BindingResult bindingResult, Model model) {
        postService.updatePost(postForm);
        return "redirect:/postAdmin";
    }



    @GetMapping("/postAdminAdd")
    public String registration(Model model) {
        model.addAttribute("postForm", new Post());
        return "newPost";
    }



    @PostMapping("/postAdminAdd")
    public String addUser(@ModelAttribute("postForm")  Post postForm, BindingResult bindingResult, Model model) {

        if (!postService.saveUser(postForm)){
            return "postAdminAdd";
        }

        return "redirect:/postAdmin";
    }
}
