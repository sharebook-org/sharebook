package org.sharebook.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.sharebook.model.Hot;
import org.sharebook.service.HotService;

import java.io.IOException;
import java.util.List;


public class HotServiceImpl implements HotService {

    //微博热搜接口地址
    private final static String WEIBO_URL = "https://www.printf520.com:8080/GetTypeInfo?id=58";

    @Override
    public List<Hot> getHots() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        List<Hot> list = null;
        try {
            HttpGet httpGet = new HttpGet(WEIBO_URL);
            httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                JSONObject json = JSONObject.parseObject(result);
                String data = json.get("Data").toString();
                list = JSONObject.parseArray(data, Hot.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException("热搜接口失效", e);
        } finally {
            if (httpResponse != null) {
                httpResponse.close();
            }
        }
        return list;
    }
}
