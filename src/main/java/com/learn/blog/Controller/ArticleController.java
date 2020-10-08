package com.learn.blog.Controller;

import com.learn.blog.POJO.Account;
import com.learn.blog.POJO.Article;
import com.learn.blog.Response.AccountResponse;
import com.learn.blog.Response.ArticleResponse;
import com.learn.blog.Service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/Article")
public class ArticleController {
        @Resource
        private ArticleService articleService;

        Article articlePresent=new Article();

        //查询一篇文章
        @GetMapping("/search/{id}")
        public ArticleResponse searchArticle(@PathVariable Integer id)
        {
            articlePresent=articleService.getArticle(id);
            log.info("select article"+articlePresent);
            if(articlePresent==null)
                return ArticleResponse.searchFail();
            return ArticleResponse.searchSuccess(articlePresent);
        }

        //显示数据库中所有文章
        @GetMapping("/showAll")
        public List<Article> searchArticle()
        {
            log.info("select article"+articlePresent);
            return articleService.getAllArticles();
        }

        //新增一篇文章   标题+文章内容
        @PostMapping("/saveArticle") public ArticleResponse saveArticle(@RequestBody Article article) {
            articleService.saveArticle(article);
            log.info("select account"+article);
            return ArticleResponse.saveSuccess();
        }

        //更改文章
        @PutMapping("/update") public ArticleResponse update(@RequestBody Article article){
            if(articlePresent==null)
                return ArticleResponse.updateFail();
            else
            {
                articlePresent.setName(article.getName());
                articlePresent.setText(article.getText());
                articleService.updateArticle(articlePresent);
            }
            return ArticleResponse.updateSuccess();
        }

        //新增一篇文章   标题+文章内容
        @DeleteMapping("/delete/{id}") public ArticleResponse deleteArticle(@PathVariable Integer id) {
        articleService.deleteArticle(id);
        return ArticleResponse.deleteSuccess();
    }

    }


