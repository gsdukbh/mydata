package top.werlst.poetry.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.werlst.poetry.entity.TangSongShi;

/**
 * @author : Lee JiaWei
 * @version V1.0
 * @Project: data
 * @date Date : 2020/7/17 17:52
 */
@Repository
public interface TangSongShiJpaRepository extends JpaRepository<TangSongShi, Integer> {

}
