package org.sharebook.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.util.Collection;
import java.util.List;

public interface UploadService {
    List<String> upload(Collection<Part> parts, HttpServletRequest request);
}
