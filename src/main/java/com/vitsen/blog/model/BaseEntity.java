package com.vitsen.blog.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	@Id
	@Column(name = "UUID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private UUID id;

	@Column(name = "CREATED_AT", nullable = false)
	@NotNull
	private LocalDateTime createdAt;

	@Column(name = "CHANGED_AT", nullable = false)
	@NotNull
	private LocalDateTime changedAt;

	@Column(name = "CREATED_BY", nullable = false)
	@NotNull
	private String createdBy;

	@PrePersist
	void preInsert() {
		LocalDateTime now = LocalDateTime.now();

		if (this.createdAt == null) {
			this.createdAt = now;
		}
		if (this.changedAt == null) {
			this.changedAt = now;
		}
	}
}
