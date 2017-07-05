package com.example.lenovo.tianqishujuku.www;

import java.io.File;

/**
 * Created by lenovo on 2017/6/2.
 */

public class TestFile {
    public void deleteAllFile(String path){
        File file=new File(path);
//        是否是文件夹
        if (file.isDirectory()){
            String[] files=file.list();
            for (String fileE:files){
                deleteAllFile(fileE);
            }
        }else {
//            删除
            file.delete();
        }
    }
}
