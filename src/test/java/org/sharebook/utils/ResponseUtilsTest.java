package org.sharebook.utils;

import org.junit.Test;

public class ResponseUtilsTest {

    @Test
    public void success() {
        System.out.println(ResponseUtils.success());
    }

    @Test
    public void error() {
        System.out.println(ResponseUtils.error());
    }
}