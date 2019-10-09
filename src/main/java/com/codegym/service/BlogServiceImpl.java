package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.BlogReposiotry;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogReposiotry blogReposiotry;

    @Override
    public List<Blog> findAll() {
        return blogReposiotry.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogReposiotry.save(blog);
    }
}
