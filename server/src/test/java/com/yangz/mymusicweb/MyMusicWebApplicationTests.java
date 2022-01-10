package com.yangz.mymusicweb;

import com.yangz.mymusicweb.entity.Singer;
import com.yangz.mymusicweb.entity.Song;
import com.yangz.mymusicweb.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class MyMusicWebApplicationTests {

    @Autowired
    ConsumerService consumerService;
    @Autowired
    AdminService adminService;
    @Autowired
    CollectService collectService;
    @Autowired
    CommentService commentService;
    @Autowired
    ListSongService listSongService;
    @Autowired
    RankService rankService;
    @Autowired
    SingerService singerService;
    @Autowired
    SongService songService;
    @Autowired
    SongListService songListService;

    @Test
    void contextLoads() {
//        Consumer consumer = new Consumer();
//        consumer.setUsername("181818");
//        consumer.setId(29);
//        consumer.setPassword("181818");
//        consumer.setSex(new Byte("0"));
//        consumer.setPhoneNum("3838438");
//        consumer.setEmail("123456@qq.com");
//        consumer.setBirth(new Date());
//        consumer.setIntroduction("Test");
//        consumer.setLocation("xx");
//        consumer.setAvator("img/user321.jpg");
//        consumer.setUpdateTime(new Date());
        //test userOfId :Pass
//        System.out.println(consumerService.userOfId(2));
//        System.out.println(consumerService.deleteUser(1)); PASS
//        System.out.println(consumerService.updateUserAvator(consumer));PASS
//        System.out.println(consumerService.updateUserMsg(consumer));PASS
//        System.out.println(        consumerService.loginStatus("181818"));PASS
//        System.out.println(        consumerService.verifyPasswd("181818", "181818"));PASS

//        Admin admin = new Admin();
//        admin.setId(1);
//        admin.setName("admin");
//        admin.setPassword("123");
//        System.out.println(        adminService.verifyPasswd(admin.getName(), admin.getPassword()));PASS
//        System.out.println(        collectService.existSongId(1,21));PASS
//        Collect collect = new Collect();
//        collect.setId(2);
//        collect.setUserId(1);
//        collect.setType(new Byte("0"));
//        collect.setSongId(100);
//        System.out.println(        collectService.addCollection(collect));PASS
//        System.out.println(collectService.allCollection());PASS
//        System.out.println(collectService.collectionOfUser(1)); PASS
//        System.out.println(collectService.deleteCollection(1, 100));
//        System.out.println(collectService.updateCollectMsg(collect));PASS

//        Comment comment  = new Comment();
//        comment.setType(new Byte("0"));
//        comment.setSongId(100);
//        comment.setCreateTime(new Date());
//        comment.setUserId(1);
//        comment.setContent("What a day");
//        comment.setId(57);
//        comment.setUp(2);
//        comment.setContent("Fantastic");
//        System.out.println(commentService.allComment());PASS
//        System.out.println(commentService.addComment(comment));PASS
//        System.out.println(commentService.deleteComment(58));PASS
//        System.out.println(commentService.commentOfSongId(0));PASS
//        System.out.println(commentService.commentOfSongListId(1));PASS
//        System.out.println(commentService.commentOfLike(comment));PASS
//        System.out.println(commentService.updateCommentMsg(comment));PASS

        /*\
        updateListSongMsg
         */
//        System.out.println(listSongService.allListSong());PASS
//        System.out.println(listSongService.listSongOfSongId(1));PASS
//        ListSong listSong = new ListSong();
//        listSong.setId(1);
//        listSong.setSongId(111);
//        listSong.setSongListId(111);
//        System.out.println(listSongService.addListSong(listSong));PASS
//        System.out.println(listSongService.deleteListSong(300));PASS
//        System.out.println(        listSongService.updateListSongMsg(listSong));PASS
//        System.out.println(rankService.rankOfSongListId(2));PASS
//        Rank rank = new Rank();
//        rank.setSonglistid(6L);
//        rank.setConsumerid(2L);
//        rank.setScore(5);
//        System.out.println(rankService.addRank(rank));PASS
    }

    //Singer
    @Test
    public void singerTest(){ //PASS
        Singer singer = new Singer();
        singer.setName("Álvaro Soler");
        singer.setSex(new Byte("1"));
        singer.setPic("/img/singerPic/soler.jpg");
        singer.setBirth(new Date());
        singer.setLocation("西班牙");
        singer.setIntroduction("全名是Álvaro Tauchert Soler，是一位新晋西班牙歌手，流行音乐作曲家。出生于1991年，西班牙巴塞罗纳。");
        System.out.println(        singerService.addSinger(singer));
    }

    @Test
    public void singerTest2()//pass
    {
        System.out.println(singerService.allSinger());
        System.out.println(singerService.singerOfSex(1));
        System.out.println(singerService.singerOfName("周杰伦"));
    }

    @Test
    public void singerTest3() {//pass
        System.out.println(singerService.deleteSinger(44));
    }

    @Test
    public void singerTest4() {//pass
        Singer singer = new Singer();
        singer.setId(45);
        singer.setPic("azzxx");
        System.out.println(singerService.updateSingerPic(singer));
    }

    @Test
    public void songTest(){//pass
            Song song = new Song();
            song.setName("Sanna");
            song.setPic("/img/songPic/1775711278864263.jpg");
            song.setSingerId(42);
            song.setCreateTime(new Date());
            song.setUpdateTime(new Date());
            song.setIntroduction("Undo");
            song.setLyric("[00:00:00]暂无歌词");
            song.setUrl("/song/Sanna Nielsen-Undo.mp3");
            songService.addSong(song);
    }

    @Test
    public void songTest2() {//pass
        System.out.println(songService.allSong());
        System.out.println(songService.songOfSingerId(1));
        System.out.println(songService.songOfId(1));
        System.out.println(songService.songOfSingerName("张杰"));
        System.out.println(songService.songOfName("张杰-仰望星空"));
    }

    @Test
    public void songListTest1() {//pass
//        System.out.println(songListService.allSongList());
//        System.out.println(songListService.likeStyle("轻音乐"));
//        System.out.println(songListService.likeTitle("%Good%"));
//        System.out.println(songListService.songListOfTitle("The Good, the Bad and the Ugly"));
    }

    @Test
    public void adminTest() {
        System.out.println(        adminService.verifyPasswd("admin", "123"));
    }

}
