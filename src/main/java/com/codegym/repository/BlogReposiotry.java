package com.codegym.repository;

import com.codegym.model.Blog;

import java.util.List;

public interface BlogReposiotry {
    List<Blog> findAll();
    void save(Blog blog);
}
