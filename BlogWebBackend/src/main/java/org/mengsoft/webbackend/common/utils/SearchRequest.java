package org.mengsoft.webbackend.common.utils;

import lombok.Data;

@Data
public class SearchRequest {
    private String keyword;
    private Paging paging;

}
