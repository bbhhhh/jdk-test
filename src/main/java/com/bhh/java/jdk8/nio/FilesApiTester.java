package com.bhh.java.jdk8.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2023/3/7 9:19
 * @Description:
 */

@Slf4j
public class FilesApiTester {
    public static void main(String[] args){
        Path ftpFilePath = Paths.get("/home","test","2020") ;
        if (Files.exists(ftpFilePath, LinkOption.NOFOLLOW_LINKS)) {
            if (!Files.isDirectory(ftpFilePath, LinkOption.NOFOLLOW_LINKS)) {
                log.error("Cannot create directory={}, File exists", ftpFilePath);
            }
        } else {
            try {
                Files.createDirectory(ftpFilePath);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
