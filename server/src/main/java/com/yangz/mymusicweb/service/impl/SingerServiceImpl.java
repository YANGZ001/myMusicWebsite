package com.yangz.mymusicweb.service.impl;

import com.yangz.mymusicweb.dao.SingerMapper;
import com.yangz.mymusicweb.entity.Singer;
import com.yangz.mymusicweb.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.yangz.mymusicweb.service.impl
 * @Author Zhang Yang
 * @Date 9/1/22 3:25 PM
 * @Version V1.0
 */
@Service
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerMapper singerMapper;

    @Override
    public boolean addSinger(Singer singer) {
        return singerMapper.insertSelective(singer) > 0;
    }

    @Override
    public List<Singer> allSinger() {
        return singerMapper.allSinger();
    }

    @Override
    public List<Singer> singerOfName(String name) {
        return singerMapper.singerOfName(name);
    }

    @Override
    public List<Singer> singerOfSex(int parseInt) {
        return singerMapper.singerOfSex(parseInt);
    }

    @Override
    public boolean deleteSinger(int parseInt) {
        return singerMapper.deleteSinger(parseInt)>0;
    }

    @Override
    public boolean updateSingerMsg(Singer singer) {
        return singerMapper.updateSingerMsg(singer)>0;
    }

    @Override
    public boolean updateSingerPic(Singer singer) {
        return singerMapper.updateSingerPic(singer)>0;
    }
}
