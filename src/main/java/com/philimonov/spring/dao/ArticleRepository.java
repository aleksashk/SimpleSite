package com.philimonov.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.philimonov.spring.model.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {
}
