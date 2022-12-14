package com.gr8.jobhunt.entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;
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
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "Required")
	private String name;

	@Column(length = 100, nullable = false)
	@NotBlank(message = "Required")
	private String password;

	@Column(length = 100, nullable = false, unique = true)
	@NotBlank(message = "Required")
	private String gmail;

	@Column(columnDefinition = "ENUM('active', 'deactivated', 'banned', 'violated') NOT NULL")
	@Enumerated(EnumType.STRING)
	private UserStatus status;

	@Column(columnDefinition = "ENUM('admin', 'user','compnay') NOT NULL")
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@Column(nullable = false)
	private String about;
	
	@Column(nullable = false)
	private String address;
	
	@Column(length = 200)
	@NotBlank(message = "Required")
	private String profilePath;

	@Column(nullable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

}
