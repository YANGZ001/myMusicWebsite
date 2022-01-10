package com.yangz.mymusicweb.entity;

import java.util.Date;

public class Collect {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column collect.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column collect.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column collect.type
     *
     * @mbggenerated
     */
    private Byte type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column collect.song_id
     *
     * @mbggenerated
     */
    private Integer songId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column collect.song_list_id
     *
     * @mbggenerated
     */
    private Integer songListId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column collect.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column collect.id
     *
     * @return the value of collect.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column collect.id
     *
     * @param id the value for collect.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column collect.user_id
     *
     * @return the value of collect.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column collect.user_id
     *
     * @param userId the value for collect.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column collect.type
     *
     * @return the value of collect.type
     *
     * @mbggenerated
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column collect.type
     *
     * @param type the value for collect.type
     *
     * @mbggenerated
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column collect.song_id
     *
     * @return the value of collect.song_id
     *
     * @mbggenerated
     */
    public Integer getSongId() {
        return songId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column collect.song_id
     *
     * @param songId the value for collect.song_id
     *
     * @mbggenerated
     */
    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column collect.song_list_id
     *
     * @return the value of collect.song_list_id
     *
     * @mbggenerated
     */
    public Integer getSongListId() {
        return songListId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column collect.song_list_id
     *
     * @param songListId the value for collect.song_list_id
     *
     * @mbggenerated
     */
    public void setSongListId(Integer songListId) {
        this.songListId = songListId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column collect.create_time
     *
     * @return the value of collect.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column collect.create_time
     *
     * @param createTime the value for collect.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", userId=" + userId +
                ", type=" + type +
                ", songId=" + songId +
                ", songListId=" + songListId +
                ", createTime=" + createTime +
                '}';
    }
}