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
import java.util.ResourceBundle;

public class HotServiceImpl implements HotService {

    private final ResourceBundle bundle = ResourceBundle.getBundle("hots-api");

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    @Override
    public List<Hot> getWeiboHots() {
        List<Hot> list = null;
        try {
            list = getData("weibo");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Hot> getZhihuHots() {
        List<Hot> list = null;
        try {
            list = getData("zhihu");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Hot> getHupuHots() {
        List<Hot> list = null;
        try {
            list = getData("hupu");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Hot> getTianyaHots() {
        List<Hot> list = null;
        try {
            list = getData("tianya");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private List<Hot> getData(String apiName) throws IOException {
        CloseableHttpResponse httpResponse = null;
        List<Hot> list = null;
        try {
            String url = bundle.getString(apiName);
            HttpGet httpGet = new HttpGet(url);
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
        } finally {
            if (httpResponse != null) {
                httpResponse.close();
            }
        }
        return list;
    }
}
