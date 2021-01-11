package spring.model.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AopAdvice {

	public void test() {
		System.out.println("aop advice run.");
	}	
	
	public void after( ) {
		System.out.println("aop after run.");
	}
	
	public Object around (ProceedingJoinPoint jp)throws Throwable {
		
		return jp.proceed();
		
	}
	
}
