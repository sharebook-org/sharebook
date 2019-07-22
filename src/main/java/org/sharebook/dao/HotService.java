package org.sharebook.service;

import org.sharebook.model.Hot;

import java.util.List;

public interface HotService {

    /**
     * 获取微博热门
     *
     * @return
     */
    List<Hot> getWeiboHots();

    /**
     * 获取知乎热门
     *
     * @return
     */
    List<Hot> getZhihuHots();

    /**
     * 获取虎扑热门
     *
     * @return
     */
    List<Hot> getHupuHots();

    /**
     * 获取天涯热门
     *
     * @return
     */
    List<Hot> getTianyaHots();
}
