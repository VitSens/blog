package com.vitsen.blog.article.service;

import com.vitsen.blog.article.entity.Article;
import java.util.List;

public interface ArticleService {

	List<Article> findArticles();
}
