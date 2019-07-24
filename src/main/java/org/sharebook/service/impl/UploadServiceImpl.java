package org.sharebook.service.impl;

import org.sharebook.service.UploadService;
import org.sharebook.utils.FileUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UploadServiceImpl implements UploadService {

    @Override
    public List<String> upload(Collection<Part> parts, HttpServletRequest request) {
        //判断是上传单个文件还是多个文件
        List<String> list = new ArrayList<>();
        for (Part part: parts){
//                part = request.getPart("file");
                String url = getUrl(part, request);
                list.add(url);
        }
        return list;
    }

    private String getUrl(Part part,HttpServletRequest request){
        String path=request.getServletContext().getRealPath("upload");
        String header=part.getHeader("Content-Disposition");
        //获取上传文件的名字
        String fileName = FileUtils.getFileName(header);
        try {
            part.write(path+ File.separator+fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //图片路径
        String imgPath=File.separator+"upload"+File.separator+fileName;
        return imgPath;
    }
}
