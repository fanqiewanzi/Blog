package com.learn.blog.Service;

import com.learn.blog.POJO.Account;
import com.learn.blog.POJO.Article;

import java.util.List;

public interface ArticleServiceInterface {
    void saveArticle(Article article);
    void deleteArticle(Integer id);
    void updateArticle(Article article);
    Article getArticle(Integer id);
    List<Article> getAllArticles();
}
