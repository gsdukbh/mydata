package top.werlst.poetry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author lee
 */
@EnableAsync
@SpringBootApplication
public class PoetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoetryApplication.class, args);
    }

}
