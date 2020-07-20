package top.werlst.poetry.controller;

import com.alibaba.fastjson.JSONReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.werlst.poetry.aop.AopLog;
import top.werlst.poetry.entity.TangSongShi;
import top.werlst.poetry.tools.Tool;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @author: Lee JiaWei
 * @date: 2020/7/17 11:35
 */
@RestController
//@RequestMapping(name = "/admin")
public class PoetryAddController {

    @Autowired
    Tool tool;

    @AopLog()
    @RequestMapping("/w")
    public String t(String string) {
        System.out.println("现在");
        tool.test();
//        try {
//            Future<String> future=tool.taskTwo();
//            if (future.isDone()){
//                System.out.println(future.get());
//            }
//            System.out.println(future.get());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return "s";
    }
    @AopLog()
    @PostMapping("/add")
    public Map<String, Object> addPoetry(@RequestParam MultipartFile file, String type) {
        Map<String, Object> res = new HashMap<>(5);
        try {
            Reader reader = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8);
            int ch = 0;
            JSONReader jsonReader = new JSONReader(reader);
            jsonReader.startArray();
            while (jsonReader.hasNext()) {
                TangSongShi tangSongSh = jsonReader.readObject(TangSongShi.class);
                System.out.println(tangSongSh.toString());
            }
            jsonReader.endArray();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        res.put("code", "ok");
        return res;
    }


}
