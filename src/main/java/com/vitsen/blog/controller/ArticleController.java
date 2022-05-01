package com.vitsen.blog.controller;

import com.vitsen.blog.article.ArticleBusinessLogic;
import com.vitsen.blog.article.entity.Article;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/articles")
@RequiredArgsConstructor
public class ArticleController {

	private final ArticleBusinessLogic articleBusinessLogic;

	@GetMapping
	public ResponseEntity<List<Article>> findArticles() {
		return ResponseEntity.ok(articleBusinessLogic.findArticles());
	}
}
