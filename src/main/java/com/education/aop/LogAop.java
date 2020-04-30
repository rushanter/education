package com.education.aop;


import com.education.constants.ResultMsg;
import com.education.service.LogService;
import com.education.service.UserInfoService;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Aspect
@Component
//@PropertySource("classpath:/action.properties")
public class LogAop {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private Environment env;

//    @Autowired
//    private LogService logService;

    private Logger logger = LoggerFactory.getLogger(LogAop.class);

//    @Before("execution(* com.education.controller.*.*(..))")
    public void before() {
        logger.info("before");
    }

    //邮箱登录日志
    @AfterReturning(returning = "rvt"
            , pointcut = "execution(* com.education.controller.*.*(..))")
    public String afterReturning(JoinPoint joinPoint, ResultMsg rvt) {


        logger.info("AfterReturning");
        return "0";
    }

    @AfterThrowing("execution(* com.education.controller.*.*(..))")
    public void afterThrowing() {
        logger.info("afterThrowing");
    }

    @After("execution(* com.education.controller.*.*(..))")
    public void after() {
        logger.info("after");
    }

//    @Around("execution(* com.education.controller.*.*(..))")
    public void around() {
        logger.info("around");
    }


}




