package _05_anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	// around advice 일 경우
	@Around("execution(public * _05_anno.*Controller.execute(..))")
	public void executeTime(ProceedingJoinPoint pjp) throws Throwable {
		long s = System.currentTimeMillis();
		try {
			// 핵심기능 메서드 호출
			pjp.proceed();
		} finally {
			long e = System.currentTimeMillis();
			double time = (e - s) / 1000d;
			System.out.println("실행시간 : " + time);
		}
	}
}







