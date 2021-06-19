package org.mengsoft.webbackend.common.utils;

import lombok.Data;
import org.mengsoft.webbackend.model.User;

@Data
public class SearchRequest {
    private String tags;
    private String categories;
    private String keyword;
    private Paging paging;
    private String sorting;

}
