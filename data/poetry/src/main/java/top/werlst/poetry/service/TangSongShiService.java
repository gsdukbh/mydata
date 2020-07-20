package top.werlst.poetry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.werlst.poetry.dao.TangSongShiJpaRepository;
import top.werlst.poetry.entity.TangSongShi;

import java.util.List;

/**
 * @author : Lee JiaWei
 * @version V1.0
 * @Project: data
 * @date Date : 2020/7/17 17:54
 */
@Service
public class TangSongShiService {
    @Autowired
    TangSongShiJpaRepository tangSongShiJpaRepository;

    public void save(TangSongShi tangSongShi){
        tangSongShiJpaRepository.save(tangSongShi);
    }
    public void save(List<TangSongShi> tangSongShi){
        tangSongShiJpaRepository.saveAll(tangSongShi);
    }
}
