package top.werlst.poetry.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Date;

/**
 * @author : Lee JiaWei
 * @version V1.0
 * @Project: data
 * @date Date : 2020/7/20 11:50
 */
@Entity
@Table
@Data
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private long logId;
    private String methodName;
    private String className;
    private String paramName;
    private String paramValue;
    private String ip;
    private String value;
    private long spendTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date time;

}
