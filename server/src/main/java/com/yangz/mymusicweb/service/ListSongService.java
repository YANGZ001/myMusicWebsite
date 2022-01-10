package com.yangz.mymusicweb.service;

import com.yangz.mymusicweb.entity.ListSong;

import java.util.List;

/**
 * @Package com.yangz.mymusicweb.service
 * @Author Zhang Yang
 * @Date 9/1/22 12:01 PM
 * @Version V1.0
 */
public interface ListSongService {
    List<ListSong> allListSong();

    List<ListSong> listSongOfSongId(int songListId);

    boolean deleteListSong(int songId);

    boolean addListSong(ListSong listsong);

    boolean updateListSongMsg(ListSong listsong);
}
