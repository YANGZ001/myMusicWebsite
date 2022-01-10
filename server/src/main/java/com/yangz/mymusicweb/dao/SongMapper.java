package com.yangz.mymusicweb.dao;

import com.yangz.mymusicweb.entity.Song;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SongMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table song
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table song
     *
     * @mbggenerated
     */
    int insert(Song record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table song
     *
     * @mbggenerated
     */
    int insertSelective(Song record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table song
     *
     * @mbggenerated
     */
    Song selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table song
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Song record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table song
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(Song record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table song
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Song record);

    int updateSongMsg(Song record);

    int updateSongUrl(Song record);

    int updateSongPic(Song record);

    int deleteSong(Integer id);

    List<Song> allSong();

    List<Song> songOfSingerId(Integer singerId);

    List<Song> songOfId(Integer id);

    List<Song> songOfSingerName(String name);

    List<Song> songOfName(String name);
}