package _04_schema;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimeAspect {
	// around advice 일 경우
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







