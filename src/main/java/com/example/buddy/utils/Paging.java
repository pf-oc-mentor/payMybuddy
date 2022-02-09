package com.example.buddy.utils;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Paging {
	/*
	 * <p> The original code comes from : <a href=
	 * "https://frontbackend.com/thymeleaf/spring-boot-bootstrap-thymeleaf-pagination-jpa-liquibase-h2">
	 * frontbackend.com </a> </p>
	 */
    private static final int PAGINATION_STEP = 3;

    private boolean nextEnabled;
    private boolean prevEnabled;
    private int pageNumber;

    private List<PageItem> items = new ArrayList<>();

   
    public void addPageItems(int from, int to, int pageNumber) {
        for (int i = from; i < to; i++) {
            items.add(PageItem.builder()
                              .active(pageNumber != i)
                              .index(i)
                              .pageItemType(PageItemType.PAGE)
                              .build());
        }
    }
    
    /**
     * Creates 2 pageItems.
     
     */
    public void last(int totalPages) {
        items.add(PageItem.builder()
                          .active(false)
                          .pageItemType(PageItemType.DOTS)
                          .build());

        items.add(PageItem.builder()
                          .active(true)
                          .index(totalPages)
                          .pageItemType(PageItemType.PAGE)
                          .build());
    }
    
    
     
    public void first() {
        items.add(PageItem.builder()
                          .active(true)
                          .index(1)
                          .pageItemType(PageItemType.PAGE)
                          .build());

        items.add(PageItem.builder()
                          .active(false)
                          .pageItemType(PageItemType.DOTS)
                          .build());
    }
    
    
    
    public static Paging of(int totalPages, int pageNumber){
        Paging paging = new Paging();
        paging.setNextEnabled(pageNumber != totalPages);
        paging.setPrevEnabled(pageNumber != 1); 
        paging.setPageNumber(pageNumber);

       
        if (totalPages < PAGINATION_STEP * 2 + 6) {
            paging.addPageItems(1, totalPages + 1, pageNumber);
        
        } else if (pageNumber < PAGINATION_STEP * 2 + 1) { 
            paging.addPageItems(1, PAGINATION_STEP * 2 + 4, pageNumber);
            paging.last(totalPages);
       
        } else if (pageNumber > totalPages - PAGINATION_STEP * 2) { 
            paging.first();
            paging.addPageItems(totalPages - PAGINATION_STEP * 2 - 2, totalPages + 1, pageNumber);
        
        } else {
            paging.first();
            paging.addPageItems(pageNumber - PAGINATION_STEP, pageNumber + PAGINATION_STEP + 1, pageNumber);
            paging.last(totalPages);
        }

        return paging;
    }
}
