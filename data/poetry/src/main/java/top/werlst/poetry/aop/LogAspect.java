package top.werlst.poetry.aop;

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
import top.werlst.poetry.tools.GetIpAdd;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
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
    GetIpAdd getIpAdd;

    @Pointcut(value = "@annotation(top.werlst.poetry.aop.AopLog)")
    public void log() {
    }

    @Before("log()")
    public void before() {
        System.out.println();
        System.out.println("之前");
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
        l(point, time);
        return result;
    }

    public void l(ProceedingJoinPoint point, long time) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        AopLog logAnnotation = method.getAnnotation(AopLog.class);
        System.out.println(logAnnotation.value());
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        System.out.println(methodName);
        System.out.println(className);
        System.out.println(time);
        // 请求的方法参数值
        Object[] args = point.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        System.out.println(Arrays.toString(paramNames));
        ;
        // 获取request
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        System.out.println(getIpAdd.getIpAddr(request));
        // 设置IP地址
    }
}
