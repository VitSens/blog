package com.vitsen.blog.article;

import com.vitsen.blog.article.entity.Article;
import com.vitsen.blog.article.service.ArticleService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleBusinessLogicImpl implements ArticleBusinessLogic {

	private final ArticleService articleService;

	@Override
	public List<Article> findArticles() {
		return articleService.findArticles();
	}

	@Override
	public Article findArticleById(UUID id) {
		return articleService.findArticleById(id);
	}

}
