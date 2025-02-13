package com.example.form.bo;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Formtest {
	@Id
	private Integer id;
	private String name;
	private Integer kilometers;
	private Double price;
	private LocalDateTime creation;
	private String email;
	private String phonenumber;
	private Boolean good;
	private String season;
	private String color;
	private String image;
	private String pdf;
}
