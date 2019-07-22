package org.sharebook.utils;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtils {

    public static String success() {
        return success("执行成功");
    }

    public static String success(String message) {
        ResponseData data = new ResponseData(200, message);
        return JSON.toJSONString(data);
    }

    public static String error() {
        return error("执行失败");
    }

    public static String error(String message) {
        ResponseData data = new ResponseData(404, message);
        return JSON.toJSONString(data);
    }

    public static void write(HttpServletResponse response, String message) {
        try {
            response.getWriter().write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class ResponseData {
        private int code;
        private String message;
    }
}
