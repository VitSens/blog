package com.vitsen.blog.article;

import com.vitsen.blog.article.entity.Article;
import java.util.List;
import java.util.UUID;

public interface ArticleBusinessLogic {

	List<Article> findArticles();

	Article findArticleById(UUID id);
}
