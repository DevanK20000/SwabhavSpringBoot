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
public class PageResponse<T> {
    private int totalPages;
    private int size;
    private Long totalElements;
    private boolean isLastPage;
    private List<T> content;
}
