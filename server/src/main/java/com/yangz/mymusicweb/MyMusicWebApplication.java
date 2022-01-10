package com.yangz.mymusicweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yangz.mymusicweb.dao")
public class MyMusicWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyMusicWebApplication.class, args);
    }

}
