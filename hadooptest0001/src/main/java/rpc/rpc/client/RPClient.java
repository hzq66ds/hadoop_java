package rpc.rpc.client;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import rpc.rpc.server.MyBusiness;

import java.net.InetSocketAddress;


public class RPClient {

	public static void main(String[] args) throws Exception {
		System.out.println("************ RPC Client**************");

		// �ͻ����õ�Server�Ĵ������
		MyBusiness proxy = (MyBusiness) RPC.getProxy(MyBusiness.class,
				             MyBusiness.versionID, 
				             new InetSocketAddress("localhost", 8888), 
				             new Configuration());
		
		
		//����proxy����server�˵�Ӧ��
		System.out.println(proxy.sayHello("Tom"));
	}
}












