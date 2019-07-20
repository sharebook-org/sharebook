package org.sharebook.service;

import org.sharebook.model.Hot;

import java.io.IOException;
import java.util.List;

public interface HotService {

    List<Hot> getHots() throws IOException;
}
