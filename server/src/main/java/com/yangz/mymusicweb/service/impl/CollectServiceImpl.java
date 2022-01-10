package com.yangz.mymusicweb.service.impl;

import com.yangz.mymusicweb.dao.CollectMapper;
import com.yangz.mymusicweb.entity.Collect;
import com.yangz.mymusicweb.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.yangz.mymusicweb.service.impl
 * @Author Zhang Yang
 * @Date 8/1/22 9:20 PM
 * @Version V1.0
 */
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;

    @Override
    public boolean addCollection(Collect collect) {
        return collectMapper.addCollection(collect) > 0;
    }

    @Override
    public boolean existSongId(int user_id, int song_id) {
        return collectMapper.existSongId(user_id, song_id) > 0;
    }

    @Override
    public List<Collect> allCollection() {
        return collectMapper.allCollection();
    }

    @Override
    public List<Collect> collectionOfUser(int user_id) {
        return collectMapper.collectionOfUser(user_id);
    }

    @Override
    public boolean deleteCollection(int user_id, int song_id) {
        return collectMapper.deleteCollection(user_id, song_id) > 0;
    }

    @Override
    public boolean updateCollectMsg(Collect collect) {
        return collectMapper.updateCollectMsg(collect) > 0;
    }
}