package com.bh.bhlibrary.Util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class UploadUtil {
    public static String getRandomString(int length){
        String base = "abcefghigklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<length;i++){
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();

    }
}
