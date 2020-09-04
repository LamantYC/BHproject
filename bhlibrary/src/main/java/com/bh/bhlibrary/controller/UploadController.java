package com.bh.bhlibrary.controller;


import com.bh.bhlibrary.Util.UploadUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.IOException;

@CrossOrigin
@RestController
public class UploadController extends HttpServlet {
//    @Autowired
//    private UploadService uploadService;

    /**
     * 本地图片上传
     */

//    @PostMapping("/image")
//    public ResponseEntity<String> uploadImage(@RequestParam(name = "file")MultipartFile file){
//        return ResponseEntity.ok(uploadService.uploadIxmage(file));
//    }
//
//
//    * 获取oss的签名
//    *
//    *
//    @GetMapping("/signature")
//    public ResponseEntity<Map<String,Object>> signature(){
//        return ResponseEntity.ok(uploadService.getSignature());
//    }
//    }
    @PostMapping("/api/covers")
    public String coversUpload(MultipartFile file) {
        String folder = "d:/vue/img1";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, UploadUtil.getRandomString(6) +
                file.getOriginalFilename().
                        substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8090/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
