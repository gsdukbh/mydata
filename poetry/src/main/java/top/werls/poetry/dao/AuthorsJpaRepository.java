package top.werls.poetry.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.werls.poetry.entity.Authors;

/**
 * @author : Lee JiaWei
 * @version V1.0
 * @Project: data
 * @Date : 2020/7/21 16:44
 */
@Repository
public interface AuthorsJpaRepository extends JpaRepository<Authors, Integer> {

}
