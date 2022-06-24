package com.vitsen.blog.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.vitsen.blog.BlogApplication;
import com.vitsen.blog.article.entity.Article;
import com.vitsen.blog.article.repository.ArticleRepository;
import com.vitsen.blog.article.service.ArticleService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BlogApplication.class})
class ArticleServiceTest {

	@Autowired
	private ArticleService articleService;

	@MockBean
	private ArticleRepository articleRepository;

	private Article article;

	@BeforeEach
	void init() {
		article = new Article();
		article.setText("Hello");
		article.setTitle("Hello");
	}

	@Test
	void getArticles_isOK() {
		doReturn(List.of(article)).when(articleRepository).findAll();

		List<Article> articles = articleService.findArticles();

		assertThat(articles).hasSize(1);
		verify(articleRepository, times(1)).findAll();
	}

	@Test
	void getArticleById_isOk() {
		UUID uuid = UUID.randomUUID();
		doReturn(Optional.of(article)).when(articleRepository).findById(uuid);

		Article article = articleService.findArticleById(uuid);

		assertThat(article.getTitle()).isEqualTo("Hello");
		assertThat(article.getText()).isEqualTo("Hello");
		verify(articleRepository, times(1)).findById(any());
	}
}
