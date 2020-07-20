package top.werlst.poetry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.werlst.poetry.dao.LogJpaRepository;
import top.werlst.poetry.entity.Log;

/**
 * @author : Lee JiaWei
 * @version V1.0
 * @Project: data
 * @date Date : 2020/7/20 14:25
 */
@Service
public class LogService {
    @Autowired
    LogJpaRepository logJpaRepository;

    /**
     * 保存Log 对象
     * @param log log 对象
     * @return Log 对象
     */
    public Log save(Log log){
        return  logJpaRepository.save(log);
    }

}
