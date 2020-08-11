package top.werls.poetry.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : Lee JiaWei
 * @version V1.0
 * @Project: data
 * @Date : 2020/7/21 16:12
 */
@Entity
@Table
@Data
public class Authors implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long autId;
    @Column(columnDefinition = "text")
    private String desc;
    @Column(columnDefinition = "text")
    private String description;
    private String era;
}
