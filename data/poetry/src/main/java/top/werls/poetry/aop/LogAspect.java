package top.werls.poetry.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.werls.poetry.entity.Log;
import top.werls.poetry.service.LogService;
import top.werls.poetry.tools.Tool;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author : Lee JiaWei
 * @version V1.0
 * @Project: data
 * @date Date : 2020/7/17 14:27
 */
@Aspect
@Component
public class LogAspect {
    @Autowired
    Tool tool;

    @Autowired
    LogService logService;

    @Pointcut(value = "@annotation(top.werls.poetry.aop.AopLog)")
    public void log() {
    }

    @Before("log()")
    public void before() {
//        System.out.println("之前");
    }

    @Around("log()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(point, time);
        return result;
    }

    /**
     *  保存方法日志
     * @param point ProceedingJoinPoint 切入点
     * @param time  long 执行时间
     */
    public void saveLog(ProceedingJoinPoint point, long time) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        AopLog logAnnotation = method.getAnnotation(AopLog.class);

        Log log=new Log();

        log.setValue(logAnnotation.value());
        System.out.println(logAnnotation.value());
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();

        log.setMethodName(className+"."+methodName);
        log.setSpendTime(time);

        System.out.println(className+"."+methodName);
        System.out.println(time+"ms");
        Object[] args = point.getArgs();
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        System.out.println(Arrays.toString(paramNames));

        System.out.println(Arrays.toString(args));
        String  temp=Arrays.toString(args);
        temp=temp.replace("[","");
        temp=temp.replace("]","");
        String[] value=temp.split(",");
        Map<String,String> save=new HashMap<>();
        for (int i = 0; i < Objects.requireNonNull(paramNames).length; i++){
            save.put(paramNames[0],value[i]);
        }
        log.setParamValue(JSON.toJSONString(save));
        
        if (logAnnotation.type()==0){
            HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
            System.out.println(tool.getIpAddr(request));

            log.setIp(tool.getIpAddr(request));
        }


        logService.save(log);
    }
}
