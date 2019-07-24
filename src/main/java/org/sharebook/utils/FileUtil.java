package org.sharebook.utils;

public class FileUtil {
    public static String getFileName(String header){
        /**
         * String[] tempArr1 =
         * header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数组里面的内容稍有区别
         * 火狐或者google浏览器下：
         * tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
         * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
         */
        String[] temp1=header.split(";");
        /**
         * 火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
         * IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
         */
        String[] temp2=temp1[2].split("=");
        String fileName=temp2[1].substring(temp2[1].lastIndexOf("\\")+1).replaceAll("\"","");
        return fileName;
    }
}
