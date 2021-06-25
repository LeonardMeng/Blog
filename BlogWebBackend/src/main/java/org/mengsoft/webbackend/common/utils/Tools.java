package org.mengsoft.webbackend.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Tools {

    public static Map<String, Integer> ConvertPaging(Paging paging) {
        Integer startNum = (paging.getCurrentPage() - 1) * paging.getPageSize();
        Integer endNum = paging.getCurrentPage() * paging.getPageSize();
        Map<String, Integer> pagingMap = new HashMap<>();
        pagingMap.put("startNum", startNum);
        pagingMap.put("endNum", endNum);
        return pagingMap;
    }

    public static List getRandomList(List list, int num) {
        List olist = new ArrayList<>();
        if (list.size() <= num) {
            return list;
        } else {
            Random random = new Random();
            for (int i = 0 ;i<num;i++){
                int intRandom = random.nextInt(list.size() - 1);
                olist.add(list.get(intRandom));
                list.remove(list.get(intRandom));
            }
            return olist;
        }
    }
}
