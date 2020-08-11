package top.werls.poetry.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.werls.poetry.entity.Log;

/**
 * @author : Lee JiaWei
 * @version V1.0
 * @Project: data
 * @date Date : 2020/7/20 14:23
 */
@Repository
public interface LogJpaRepository extends JpaRepository<Log, Integer> {

}
