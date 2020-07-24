package top.werls.poetry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.werls.poetry.aop.AopLog;
import top.werls.poetry.tools.Tool;
import top.werls.poetry.service.TangSongShiService;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Lee JiaWei
 * @date: 2020/7/17 11:35
 */
@RestController
//@RequestMapping(name = "/admin")
public class PoetryAddController {

    @Autowired
    Tool tool;

    @Autowired
    TangSongShiService tangSongShiService;


    @AopLog("测试")
    @RequestMapping("/w")
    public String t(String string) {
        System.out.println("现在");
//        tool.test();

/*
        try {
            Future<String> future=tool.taskTwo();
            if (future.isDone()){
                System.out.println(future.get());
            }
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
*/

        return "s";
    }

    @AopLog()
    @PostMapping("/add")
    public Map<String, Object> addPoetry(@RequestParam MultipartFile[] files, @RequestParam String type) {
        Map<String, Object> res = new HashMap<>(5);
        try {
            for (MultipartFile file : files) {
                tangSongShiService.save(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8), type);
                System.out.println(file.getOriginalFilename());
            }
        } catch (IOException e) {
            res.put("status", 403);
            res.put("message", e.getMessage());
            e.printStackTrace();
        }

        res.put("status", 200);
        return res;
    }

}
