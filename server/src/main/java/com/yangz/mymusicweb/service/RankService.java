package com.yangz.mymusicweb.service;

import com.yangz.mymusicweb.entity.Rank;

/**
 * @Package com.yangz.mymusicweb.service
 * @Author Zhang Yang
 * @Date 9/1/22 3:00 PM
 * @Version V1.0
 */
public interface RankService {
    boolean addRank(Rank rank);

    int rankOfSongListId(long songListId);
}
