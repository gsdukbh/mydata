package top.werlst.poetry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.werlst.poetry.aop.AopLog;

/**
 * @author: Lee JiaWei
 * @date: 2020/7/17 11:35
 */
@RestController
//@RequestMapping(name = "/admin")
public class PoetryAddController {
    @AopLog("wode")
    @RequestMapping("/w")
    public String t(){
        System.out.println("现在");
        System.out.println(System.currentTimeMillis());
        return "s";
    }
}
