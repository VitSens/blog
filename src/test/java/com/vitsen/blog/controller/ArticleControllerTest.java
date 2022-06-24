package com.vitsen.blog.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.vitsen.blog.article.ArticleBusinessLogic;
import com.vitsen.blog.article.entity.Article;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ArticleBusinessLogic articleBusinessLogic;

	@Test
	void is200_whenGetAll() throws Exception {
		mockMvc.perform(get("/v1/articles"))
				.andDo(print())
				.andExpect(jsonPath("$.length()").isNotEmpty())
				.andExpect(status().isOk());
	}

	@Test
	void is200_whenGetById() throws Exception {
		UUID uuid = UUID.randomUUID();
		Article article = new Article("Hello", "Hello");

		when(articleBusinessLogic.findArticleById(uuid))
				.thenReturn(article);

		mockMvc.perform(get("/v1/articles/{id}", uuid))
				.andDo(print())
				.andExpect(status().is2xxSuccessful())
				.andExpect(jsonPath("$.title").value(article.getText()))
				.andExpect(status().isOk());
	}
}
