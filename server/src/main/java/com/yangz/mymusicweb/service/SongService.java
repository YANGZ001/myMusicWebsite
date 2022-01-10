package com.yangz.mymusicweb.service;

import com.yangz.mymusicweb.entity.Song;

import java.util.List;

/**
 * @Package com.yangz.mymusicweb.service
 * @Author Zhang Yang
 * @Date 9/1/22 3:24 PM
 * @Version V1.0
 */
public interface SongService {
    boolean addSong (Song song);

    boolean updateSongMsg(Song song);

    boolean updateSongUrl(Song song);

    boolean updateSongPic(Song song);

    boolean deleteSong(Integer id);

    List<Song> allSong();

    List<Song> songOfSingerId(Integer singerId);

    List<Song> songOfId(Integer id);

    List<Song> songOfSingerName(String name);

    List<Song> songOfName(String name);
}
