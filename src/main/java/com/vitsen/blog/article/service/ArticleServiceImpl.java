package com.vitsen.blog.article.service;

import com.vitsen.blog.article.entity.Article;
import com.vitsen.blog.article.repository.ArticleRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

	private final ArticleRepository articleRepository;

	public ArticleServiceImpl(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Override
	public List<Article> findArticles() {
		return articleRepository.findAll();
	}

	@Override
	public Article findArticleById(UUID id) {
		return articleRepository.findById(id)
				.orElseThrow(RuntimeException::new);
	}
}
