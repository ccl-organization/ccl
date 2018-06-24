package com.music;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2018/6/24
 * To change this template use File | Settings | File Templates.
 **/
public class MusicModel {
    private String musicid;
    private String musicName;
    private String musicCoverUrl;
    private String musicMp3Url;

    public MusicModel(){}
    public MusicModel(String musicid, String musicName, String musicCoverUrl, String musicMp3Url) {
        this.musicid = musicid;
        this.musicName = musicName;
        this.musicCoverUrl = musicCoverUrl;
        this.musicMp3Url = musicMp3Url;
    }

    public String getMusicid() {
        return musicid;
    }

    public void setMusicid(String musicid) {
        this.musicid = musicid;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicCoverUrl() {
        return musicCoverUrl;
    }

    public void setMusicCoverUrl(String musicCoverUrl) {
        this.musicCoverUrl = musicCoverUrl;
    }

    public String getMusicMp3Url() {
        return musicMp3Url;
    }

    public void setMusicMp3Url(String musicMp3Url) {
        this.musicMp3Url = musicMp3Url;
    }
}
