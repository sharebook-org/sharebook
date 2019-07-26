package org.sharebook.servlet;

import org.sharebook.service.UploadService;
import org.sharebook.service.impl.UploadServiceImpl;
import org.sharebook.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@MultipartConfig(maxFileSize = 5765004, fileSizeThreshold = 1000)
@WebServlet(urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {
    private final UploadService uploadService = new UploadServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Collection<Part> parts = request.getParts();
        List<String> list = uploadService.upload(parts, request);
        String imgPaths = String.join("#", list);
        ResponseUtils.write(response, ResponseUtils.success("上传成功！", imgPaths));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
