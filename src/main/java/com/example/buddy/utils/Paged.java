package com.example.buddy.utils;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Paged <T> {
 private Page<T>page;
 private Paging paging;
}
