package com.vitsen.blog.article.entity;

import com.vitsen.blog.model.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "article")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Article extends BaseEntity {

	@Column(name = "TITLE", nullable = false)
	@NotNull
	private String title;

	@Column(name = "TEXT", nullable = false)
	@NotNull
	private String text;
}
