package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public ModelAndView listBlogs(){
        ModelAndView modelAndView = new ModelAndView("/blog/user/list");
        List<Blog> blogList = blogService.findAll();
        modelAndView.addObject("blogs", blogList);
        return modelAndView;
    }

    @GetMapping("/admin/blogs")
    public ModelAndView listBlogsAdmin(){
        ModelAndView modelAndView = new ModelAndView("/blog/admin/list");
        List<Blog> blogList = blogService.findAll();
        modelAndView.addObject("blogs", blogList);
        return modelAndView;
    }

    @GetMapping("/admin/create-blog")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/blog/admin/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/admin/save-blog")
    public ModelAndView create(@ModelAttribute("blog") Blog blog, Pageable pageable){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/blogs");
        return modelAndView;
    }
}
