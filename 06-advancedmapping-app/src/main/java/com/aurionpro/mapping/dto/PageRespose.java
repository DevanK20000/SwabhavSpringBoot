package com.aurionpro.mapping.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class PageRespose<T> {
	private int toatalPage;
	private int size;
	private Long totalElements;
	private List<T> content;
	private boolean isLastPage;
}
