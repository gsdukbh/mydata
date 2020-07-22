package top.werls.poetry.service;

import com.alibaba.fastjson.JSONReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.werls.poetry.aop.AopLog;
import top.werls.poetry.entity.TangSongShi;
import top.werls.poetry.dao.TangSongShiJpaRepository;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lee JiaWei
 * @version V1.0
 * @Project: data
 * @date Date : 2020/7/17 17:54
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TangSongShiService {
    @Autowired
    TangSongShiJpaRepository tangSongShiJpaRepository;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Async
    @AopLog(type = 1,value = "保存数据")
    public void save(Reader reader,String type){
        List<TangSongShi> songShiList=new ArrayList<>();
        try {
            JSONReader jsonReader=new JSONReader(reader);
            jsonReader.startArray();
            while (jsonReader.hasNext()){
                TangSongShi tangSongShi = jsonReader.readObject(TangSongShi.class);
                logger.info(tangSongShi.toString());
                tangSongShi.setType(type);

                songShiList.add(tangSongShi);
                if (songShiList.size() > 3000){
                    this.save(songShiList);
                    songShiList.clear();
                }
            }
            this.save(songShiList);
            jsonReader.endArray();
            jsonReader.close();
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void save(TangSongShi tangSongShi){
        tangSongShiJpaRepository.save(tangSongShi);
    }
    public void save(List<TangSongShi> tangSongShi){
        tangSongShiJpaRepository.saveAll(tangSongShi);
    }
}
