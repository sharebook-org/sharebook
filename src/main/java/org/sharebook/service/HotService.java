package org.sharebook.service;

import org.sharebook.model.Hot;

import java.io.IOException;
import java.util.List;

public interface HotService {

    /**
     * 获取微博热门
     *
     * @return
     * @throws IOException
     */
    List<Hot> getWeiboHots() throws IOException;

    /**
     * 获取知乎热门
     *
     * @return
     * @throws IOException
     */
    List<Hot> getZhihuHots() throws IOException;
}
