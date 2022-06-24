package com.vitsen.blog.article.service;

import com.vitsen.blog.article.entity.Article;
import java.util.List;
import java.util.UUID;

public interface ArticleService {

	List<Article> findArticles();

	Article findArticleById(UUID id);
}
