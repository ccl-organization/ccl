package com.ccl.managerapi;

import com.Uitils.ParamsCheckUtils;
import com.Uitils.PropertiesUtil;
import com.ccl.common.ErrorCCL;
import com.ccl.common.RootContraller;
import com.jedis.JedisUtils;
import com.music.MusicModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2018/6/24
 * To change this template use File | Settings | File Templates.
 **/

@Controller
@RequestMapping("/manager")
public class MangerContrallor extends RootContraller {
    public static void main(String[] args) {

       String s= PropertiesUtil.get("music.id");
       String s2=s.replace("value", "1");
        JedisUtils.set("k1","v1");
        JedisUtils.set(PropertiesUtil.get("music.id").replace("value", "1"), "1");
        System.out.println();
    }


    /**
     * @param file
     * @deprecated  上传epub文件
     * **/
    @RequestMapping(value = "/uploadepub", method = RequestMethod.POST)
    @ResponseBody
    Object upload(@RequestParam(name = "musicName" ,required=true) String musicName,
                  @RequestParam(name = "singer" ,required=false) String singer,
                  @RequestParam(name = "cover" ,required=true ) MultipartFile cover,
                  @RequestParam(name = "file" ,required=true ) MultipartFile file) {
        try {
            if (ParamsCheckUtils.checkParams(musicName, cover, file)) {
                String musicid = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();
                String mp3dir = PropertiesUtil.get("music.mp3.dir");
                String filename = file.getOriginalFilename().replaceAll(" ", "");
                String covername = cover.getOriginalFilename().replaceAll(" ", "");
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(mp3dir + "/" + filename)));
                out.write(file.getBytes());
                out.flush();
                out.close();
                String mp3url = mp3dir + "/" + filename;
                String coverurl = mp3dir + "/" + covername;

                JedisUtils.set(PropertiesUtil.get("music.id").replace("value", musicid), musicid);
                JedisUtils.set(PropertiesUtil.get("music.name").replace("value", musicid), musicName);
                JedisUtils.set(PropertiesUtil.get("music.coverurl").replace("value", musicid), coverurl);
                JedisUtils.set(PropertiesUtil.get("music.mp3url").replace("value", musicid), mp3url);

                JedisUtils.zadd("all:music:map:zadd", new Date().getTime(), musicid);


                List<MusicModel> musicList = new ArrayList<>();
                Set<String> stringSet = JedisUtils.zrevrange("all:music:map:zadd", 0, 9);
                for (String music : stringSet) {
                    MusicModel musicModel = new MusicModel();
                    musicModel.setMusicid(JedisUtils.get(PropertiesUtil.get("music.id").replace("value", music)));
                    musicModel.setMusicName(JedisUtils.get(PropertiesUtil.get("music.name").replace("value", music)));
                    musicModel.setMusicCoverUrl(JedisUtils.get(PropertiesUtil.get("music.coverurl").replace("value", music)));
                    musicModel.setMusicMp3Url(JedisUtils.get(PropertiesUtil.get("music.mp3url").replace("value", music)));
                    musicList.add(musicModel);
                }

                return respondDone(musicList);

            } else {
                return this.respondFailed(ErrorCCL.ERROR_PARAMS_ERROR, "文件为空");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return respondFailed(ErrorCCL.ERROR_EXCEOTION_ERROR,"异常 "+e.getMessage());

        }


    }
}
