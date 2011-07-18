package belajar.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class InfoArgumen implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation inv) throws Throwable {
		System.out.println("======== Info Argumen ========");
		System.out.println("Nama method : "+inv.getMethod().getName());
		System.out.println("Jumlah argumen : "+inv.getArguments().length);
		System.out.println("Nilai Argumen");
		int i = 0;
		for (Object arg : inv.getArguments()) {
			i++;
			System.out.println("Argumen "+i+" : "+arg);
		}
		
		Object hasil = inv.proceed();
		
		System.out.println("Nilai kembalian : "+hasil);
		
		System.out.println("======== Info Argumen ========");
		return hasil;
	}

}
