package com.edu.util;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

public class ImageMap {

    private static final Map<String, Image> map = new HashMap<>();
    static {
        map.put("bg01",ImageUtil.getImage("com/edu/imgs/bg/bg1.png"));

    }

    public static Image  get(String key){
        return map.get(key);
    }
}
