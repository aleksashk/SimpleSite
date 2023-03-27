package com.philimonov.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.philimonov.spring.dao.ArticleRepository;
import com.philimonov.spring.model.Article;

import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository repository;

    public void save(Article article) {
        Article savedArticle = repository.save(article);
        System.out.println(savedArticle.getId());
    }

    public List<Article> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public void delete(Integer articleId) {
        repository.delete(articleId);
    }
}
