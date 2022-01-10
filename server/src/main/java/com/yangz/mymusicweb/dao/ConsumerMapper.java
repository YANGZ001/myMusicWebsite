package com.yangz.mymusicweb.dao;

import com.yangz.mymusicweb.entity.Consumer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ConsumerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbggenerated
     */
    int insert(Consumer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbggenerated
     */
    int insertSelective(Consumer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbggenerated
     */
    Consumer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Consumer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumer
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Consumer record);

    int addUser(Consumer consumer);

    List<Consumer> allUser();

    List<Consumer> userOfId(Integer id);

    int deleteUser(Integer id);

    int updateUserMsg(Consumer consumer);

    int updateUserAvator(Consumer consumer);

    int verifyPasswd(String username, String password);

    List<Consumer> loginStatus(String username);
}