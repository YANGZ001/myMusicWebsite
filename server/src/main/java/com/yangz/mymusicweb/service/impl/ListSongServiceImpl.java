package com.yangz.mymusicweb.service.impl;

import com.yangz.mymusicweb.dao.ListSongMapper;
import com.yangz.mymusicweb.entity.ListSong;
import com.yangz.mymusicweb.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.yangz.mymusicweb.service.impl
 * @Author Zhang Yang
 * @Date 9/1/22 12:01 PM
 * @Version V1.0
 */
@Service
public class ListSongServiceImpl implements ListSongService {
    @Autowired
    private ListSongMapper listSongMapper;

    @Override
    public List<ListSong> allListSong() {
        return listSongMapper.allListSong();
    }

    @Override
    public List<ListSong> listSongOfSongId(int songListId) {
        return listSongMapper.listSongOfSongId(songListId);
    }

    @Override
    public boolean deleteListSong(int parseInt) {
        return listSongMapper.deleteListSong(parseInt) > 0;
    }

    @Override
    public boolean addListSong(ListSong listsong) {
        return listSongMapper.addListSong(listsong) > 0;
    }

    @Override
    public boolean updateListSongMsg(ListSong listsong) {
        return listSongMapper.updateListSongMsg(listsong) > 0;
    }
}
