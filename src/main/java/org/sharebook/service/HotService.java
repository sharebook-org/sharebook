package org.sharebook.service;

import org.sharebook.model.Hot;

import java.io.IOException;
import java.util.List;

public interface HotService {

    /**
     * 获取热门文章
     *
     * @return
     * @throws IOException
     */
    List<Hot> getHots() throws IOException;
}
