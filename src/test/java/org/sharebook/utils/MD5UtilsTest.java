package org.sharebook.utils;

import org.junit.Assert;
import org.junit.Test;

public class MD5UtilsTest {

    @Test
    public void md5() {
        String md = MD5Utils.md5("123", "123");
        System.out.println(md);
        Assert.assertNotNull(md);
    }

    @Test
    public void getSalt() {

        String salt = MD5Utils.getSalt();
        System.out.println(salt);
        Assert.assertEquals(4, salt.length());
    }
}