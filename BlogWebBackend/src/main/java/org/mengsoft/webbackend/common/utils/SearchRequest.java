package org.mengsoft.webbackend.common.utils;

import lombok.Data;
import org.mengsoft.webbackend.model.User;

@Data
public class SearchRequest {
    private User user;
    private String keyword;
    private Paging paging;
    private Sorting sorting;

}
