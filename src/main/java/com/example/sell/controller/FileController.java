package com.example.sell.controller;

import com.example.sell.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

//如果前后端不分离的话是Controller
@Controller
//@RestController
//@RequestMapping("/buyer/product")
public class FileController {
    //跳转到上传文件的页面
    @RequestMapping(value = "/gouploadimg", method = RequestMethod.GET)
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
        return "uploadimg";
    }

    //处理文件上传
    @RequestMapping(value = "/testuploadimg", method = RequestMethod.POST)
    //如果前后端不分离的话是需要加上ResponseBody
    public @ResponseBody
    String uploadImg(@RequestParam("file") MultipartFile file,
                     HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        /*System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);*/
        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
//        String filePath = "G:/webproject/sell/uploadfile/";
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {

        }
        //返回json
        return filePath + ":" + fileName;
    }

    @RequestMapping(value = "download", method = RequestMethod.GET)
    public String downLoad(HttpServletResponse response) {
        String fileName = "a.jpeg";
        String filePath = "F:/test";
        File file = new File("G:/webproject/sell/uploadfile/a.jpeg");
        FileInputStream in = null;
        OutputStream out = null;
        try {
            response.setContentType("application/force-download");
            if (fileName.lastIndexOf("\\") > 0) {
                fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
            }
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            out = response.getOutputStream();
            byte d[] = new byte[256];
            int count = 0;
            in = new FileInputStream(file);
            while ((count = in.read(d)) > 0) {
                out.write(d, 0, count);
                out.flush();
            }
        } catch (IOException e) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}