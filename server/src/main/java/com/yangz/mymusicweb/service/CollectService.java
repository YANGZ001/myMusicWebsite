package com.yangz.mymusicweb.service;

import com.yangz.mymusicweb.entity.Collect;

import java.util.List;

/**
 * @Package com.yangz.mymusicweb.service
 * @Author Zhang Yang
 * @Date 8/1/22 9:20 PM
 * @Version V1.0
 */
public interface CollectService {

    boolean addCollection(Collect collect);

    boolean existSongId(int user_id, int song_id);

    List<Collect> allCollection();

    List<Collect> collectionOfUser(int user_id);

    boolean deleteCollection(int user_id, int song_id);

    boolean updateCollectMsg(Collect collect);
}
