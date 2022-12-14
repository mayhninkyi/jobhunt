package com.gr8.jobhunt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Category implements java.io.Serializable {
	
	public static final long serialVersionUID=1L;
	@Id
	private int id;
	@Column(length=50, nullable=false)
	private String name;

}
