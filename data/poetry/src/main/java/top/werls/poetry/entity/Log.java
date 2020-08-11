package top.werls.poetry.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
@EntityListeners(AuditingEntityListener.class)
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long logId;
    private String methodName;
    private String paramValue;
    private String ip;
    private String value;
    private long spendTime;
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date time;
}
