package com.example.buddy.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @Data @NoArgsConstructor @AllArgsConstructor
public class PageItem {
 private PageItemType pageItemType;
 private int index;
 private boolean active;
}
