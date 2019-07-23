package org.sharebook.utils;

import org.junit.Test;
import org.sharebook.model.Hot;

import java.util.ArrayList;
import java.util.List;

public class ResponseUtilsTest {

    @Test
    public void success() {
        System.out.println(ResponseUtils.success());
        List<Hot> hots = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            hots.add(new Hot("title", "url"));
        }
        System.out.println(ResponseUtils.success("message", hots));
        System.out.println(ResponseUtils.success(hots));
    }

    @Test
    public void error() {
        System.out.println(ResponseUtils.error());
    }
}