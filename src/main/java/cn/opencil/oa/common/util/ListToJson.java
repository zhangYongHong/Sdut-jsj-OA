package cn.opencil.oa.common.util;


import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by mnzero on 16-6-30.
 */
public class ListToJson {
    public static String listToJson(List list) {
        String json = null;
        json = JSON.toJSONString(list);
        return json;
    }
}
