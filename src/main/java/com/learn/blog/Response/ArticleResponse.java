package com.learn.blog.Response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learn.blog.POJO.Article;
import lombok.Data;

@Data
public class ArticleResponse {
    private boolean isok;
    private int code;//200  400  500
    private String message;
    private Object data;

    //搜索成功
    public  static ArticleResponse searchSuccess(Article article){
        ArticleResponse articleResponse = new ArticleResponse();
        articleResponse.setIsok(true);
        articleResponse.setCode(200);
        articleResponse.setMessage("搜索成功");
        articleResponse.setData(article);
        return articleResponse;
    }

    //上传成功
    public  static ArticleResponse saveSuccess(){
        ArticleResponse articleResponse = new ArticleResponse();
        articleResponse.setIsok(true);
        articleResponse.setCode(200);
        articleResponse.setMessage("上传成功");
        return articleResponse;
    }

    //更新成功
    public  static ArticleResponse updateSuccess(){
        ArticleResponse articleResponse = new ArticleResponse();
        articleResponse.setIsok(true);
        articleResponse.setCode(200);
        articleResponse.setMessage("更新成功");
        return articleResponse;
    }

    //删除成功
    public  static ArticleResponse deleteSuccess(){
        ArticleResponse articleResponse = new ArticleResponse();
        articleResponse.setIsok(true);
        articleResponse.setCode(200);
        articleResponse.setMessage("删除成功");
        return articleResponse;
    }

    //搜索失败
    public static ArticleResponse searchFail()
    {
        ArticleResponse articleResponse = new ArticleResponse();
        articleResponse.setIsok(false);
       articleResponse.setCode(200);
        articleResponse.setMessage("没有此文章");
        return articleResponse;
    }
    //更新失败
    public static ArticleResponse updateFail()
    {
        ArticleResponse articleResponse = new ArticleResponse();
        articleResponse.setIsok(false);
        articleResponse.setCode(200);
        articleResponse.setMessage("请先搜索文章");
        return articleResponse;
    }
}
