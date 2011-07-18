package belajar.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class InfoAnnotation {
	
	@Around("execution(* belajar.spring.aop.TargetObject.halo(..))")
	public void info(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("=== Info Annotation ===");
		System.out.println("Method Signature : "+pjp.getSignature());
		pjp.proceed();
		System.out.println("=== Info Annotation ===");
	}
}
