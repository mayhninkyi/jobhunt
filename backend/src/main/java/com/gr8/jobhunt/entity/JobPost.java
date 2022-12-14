package com.gr8.jobhunt.entity;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobPost implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 50, nullable = false, unique = true)
	@NotBlank(message = "Required")
	private String title;

	@Column(length = 2000, nullable = false, unique = true)
	@NotBlank(message = "Required")
	private String description;
	
	@Column(length = 2000, nullable = false, unique = true)
	@NotBlank(message = "Required")
	private String reqirement;

	@Column(nullable = false)
	private int noOfEmployee;

	@Column(nullable = false)
	private int salary;

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;

	@Column(columnDefinition = "boolean", nullable = false)
	@ColumnDefault("false")
	private Boolean isCloseJob;

	@Column(nullable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

}
