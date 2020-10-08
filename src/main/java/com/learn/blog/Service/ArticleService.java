package com.learn.blog.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learn.blog.Mapper.ArticleMapper;

import com.learn.blog.POJO.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

@Service("com.learn.blog.Service.ArticleServiceInterface")
public class ArticleService implements ArticleServiceInterface{

    @Resource
    private ArticleMapper articleMapper;
    @Override
    public void saveArticle(Article article) {
        articleMapper.insert(article);
    }

    @Override
    public void deleteArticle(Integer id) {
       articleMapper.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateById(article);
    }

    @Override
    public Article getArticle(Integer id) {
        return articleMapper.selectById(id);
    }

    @Override
    public List<Article> getAllArticles() {
        QueryWrapper<Article> queryWrapper=new QueryWrapper<>();
        return articleMapper.selectList(queryWrapper);

    }
}
