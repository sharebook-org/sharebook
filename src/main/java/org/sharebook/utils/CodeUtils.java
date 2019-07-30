package org.sharebook.utils;

import java.util.UUID;

public class CodeUtils {
    //生成唯一的激活码
    public static String generateUniqueCode() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
