package com.yangz.mymusicweb.service.impl;

import com.yangz.mymusicweb.dao.RankMapper;
import com.yangz.mymusicweb.entity.Rank;
import com.yangz.mymusicweb.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.yangz.mymusicweb.service.impl
 * @Author Zhang Yang
 * @Date 9/1/22 3:01 PM
 * @Version V1.0
 */
@Service
public class RankServiceImpl implements RankService {
    @Autowired
    private RankMapper rankMapper;

    @Override
    public int rankOfSongListId(long songListId) {
        return rankMapper.selectScoreSum(songListId) / rankMapper.selectRankNum(songListId);
    }

    @Override
    public boolean addRank(Rank rank) {

        return rankMapper.insertSelective(rank) > 0;
    }
}
