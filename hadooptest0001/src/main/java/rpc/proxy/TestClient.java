package rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestClient {


	public static void main(String[] args) {
		//真正对象
		final MyInterface obj = new MyInterfaceImpl();

		//生成真正对象的代理对象
		MyInterface proxy = (MyInterface) Proxy.newProxyInstance(TestClient.class.getClassLoader(), //类加载器
				obj.getClass().getInterfaces(), //真正对象的行为(方法)
				//客户端调用的时候，怎么调用
				new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						if(method.getName().equals("method1")){
							//重写
							return "*******method1 in proxy**********";
						}else{
							//其他方法，调用真正的对象完成
							return method.invoke(obj, args);
						}
					}
				}
		);

		//通过调用代理对象，重写方法
		System.out.println(proxy.method1());
		System.out.println(proxy.method2());
	}
}






