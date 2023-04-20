package tko.ManageSystem.util.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
/**
 * Daniel kim
 * LogAspect : Spring AOP를 이용해 수행 시간 로그 생성
 * 2023-04-15
 */
@Aspect // 애스펙트 등록
@Slf4j // 롬복 log Annotation
@Component
public class LogAspect {

    @Around("execution(* tko..controller.*Controller.*(..))")
    public Object loginLogging(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        try {
            result = pjp.proceed();
            log.debug("debug log={}", getClass());
            log.error("error log={}", getClass());

        } catch (Throwable t) {
            System.out.println("Exception in Controller");
            t.printStackTrace();
        }


        return result;
    }


    // advice, advice Method, pointCut
//    @Around("execution(* tko..service.*Service.*(..))")
//    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
//        Object result = null;
//        try {
//            log.debug("debug log={}", getClass());
//            long start = System.currentTimeMillis();
//            result = pjp.proceed();
//            long end = System.currentTimeMillis();
//
//            System.out.println("수행시간 : " + (end - start));
//        } catch (Throwable throwable) {
//            System.out.println("Exception");
//        }
//
//        return result;
//    }
}
