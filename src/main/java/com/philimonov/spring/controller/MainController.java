package com.philimonov.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.philimonov.spring.model.Article;
import com.philimonov.spring.service.ArticleService;

@Controller
@RequestMapping("/blog")
public class MainController {

    @Autowired
    private ArticleService service;

    @RequestMapping
    public String mainPage(Model model) {
        model.addAttribute("articles", service.getAll());
        return "main";
    }

    @RequestMapping(value = "/editor")
    public String editorPage(Model model) {
        model.addAttribute("article", new Article());
        return "editor";
    }

    @RequestMapping(value = "/editor/submit", method = RequestMethod.POST)
    public String submitArticle(@ModelAttribute Article article) {
        service.save(article);
        return "redirect:../";
    }

    @RequestMapping(value = "/editor/delete/{article_id}")
    public String deteleArticle(@PathVariable("article_id") Integer articleId) {
        service.delete(articleId);
        return "redirect:../";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }
}
