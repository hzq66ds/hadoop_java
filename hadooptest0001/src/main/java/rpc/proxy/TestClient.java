package rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestClient {


	public static void main(String[] args) {
		//��������
		final MyInterface obj = new MyInterfaceImpl();

		//������������Ĵ������
		MyInterface proxy = (MyInterface) Proxy.newProxyInstance(TestClient.class.getClassLoader(), //�������
				obj.getClass().getInterfaces(), //�����������Ϊ(����)
				//�ͻ��˵��õ�ʱ����ô����
				new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						if(method.getName().equals("method1")){
							//��д
							return "*******method1 in proxy**********";
						}else{
							//�������������������Ķ������
							return method.invoke(obj, args);
						}
					}
				}
		);

		//ͨ�����ô��������д����
		System.out.println(proxy.method1());
		System.out.println(proxy.method2());
	}
}






