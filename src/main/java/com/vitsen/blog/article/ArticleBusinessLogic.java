package com.vitsen.blog.article;

import com.vitsen.blog.article.entity.Article;
import java.util.List;

public interface ArticleBusinessLogic {

	List<Article> findArticles();
}
