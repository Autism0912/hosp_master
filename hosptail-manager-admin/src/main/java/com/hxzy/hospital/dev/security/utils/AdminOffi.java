package com.hxzy.hospital.dev.security.utils;

public class AdminOffi {

    public static Integer keshi(String name){
        int num =0;
        switch (name){
            case "皮肤科":
                num =2;
                break;
            case "内科":
                num = 3;
                break;
            case "神经科":
                num = 4;
                break;
            case "口腔科":
                num =8;
                break;
            case "肛门科":
                num = 9;
                break;
        }
        return num;
    }
}
