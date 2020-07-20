package top.werlst.poetry.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: Lee JiaWei
 * @date: 2020/7/17 10:35
 */
@Entity
@Table(name = "TangSongShi")
@Data
public class TangSongShi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  long Tid;
    private String author;
    private String title;
    @Column(columnDefinition = "text")
    private String paragraphs;
}
