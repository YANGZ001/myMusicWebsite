package com.yangz.mymusicweb.service;

import com.yangz.mymusicweb.entity.Singer;

import java.util.List;

/**
 * @Package com.yangz.mymusicweb.service
 * @Author Zhang Yang
 * @Date 9/1/22 3:23 PM
 * @Version V1.0
 */
public interface SingerService {
    boolean addSinger(Singer singer);

    List<Singer> allSinger();

    List<Singer> singerOfName(String name);

    List<Singer> singerOfSex(int parseInt);

    boolean deleteSinger(int parseInt);

    boolean updateSingerMsg(Singer singer);

    boolean updateSingerPic(Singer singer);
}
