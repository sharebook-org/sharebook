package org.sharebook.utils;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * JSON相关工具类
 */
public class ResponseUtils {

    private final static int SUCCESS_CODE = 200;
    private final static int ERROR_CODE = 404;
    private final static String SUCCESS_MESSAGE = "执行成功";
    private final static String ERROR_MESSAGE = "执行失败";

    /**
     * 输出正确信息
     * @return
     */
    public static String success() {
        return success(SUCCESS_MESSAGE);
    }

    /**
     * 输出正确信息
     * @param message 给定信息
     * @return
     */
    public static String success(String message) {
        ResponseData data = new ResponseData(SUCCESS_CODE, message);
        return JSON.toJSONString(data);
    }

    /**
     * 输出正确信息
     * @param message 给定信息
     * @param object 给定数据
     * @return
     */
    public static String success(String message, Object object) {
        ResponseData data = new ResponseData(SUCCESS_CODE, message, object);
        return JSON.toJSONString(data);
    }

    /**
     * 输出正确信息
     * @param object 给定数据
     * @return
     */
    public static String success(Object object) {
        ResponseData data = new ResponseData(SUCCESS_CODE, SUCCESS_MESSAGE, object);
        return JSON.toJSONString(data);
    }

    public static String success(Object object, Map map) {
        ResponseData data = new ResponseData(SUCCESS_CODE, SUCCESS_MESSAGE, object, map);
        return JSON.toJSONString(data);
    }

    /**
     * 输出错误信息
     * @return
     */
    public static String error() {
        return error(ERROR_MESSAGE);
    }

    /**
     * 输出错误信息
     * @param message 给定信息
     * @return
     */
    public static String error(String message) {
        ResponseData data = new ResponseData(ERROR_CODE, message);
        return JSON.toJSONString(data);
    }

    /**
     * 调用Response的write方法输出
     * @param response
     * @param message
     */
    public static void write(HttpServletResponse response, String message) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * JSON返回的数据格式
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class ResponseData {
        private int code;
        private String message;
        private Object data;
        private Map ext;

        public ResponseData(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public ResponseData(int code, String message, Object data) {
            this.code = code;
            this.message = message;
            this.data = data;
        }
    }
}
