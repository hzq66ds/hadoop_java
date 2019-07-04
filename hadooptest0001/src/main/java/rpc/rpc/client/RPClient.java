package rpc.rpc.client;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import rpc.rpc.server.MyBusiness;

import java.net.InetSocketAddress;


public class RPClient {

	public static void main(String[] args) throws Exception {
		System.out.println("************ RPC Client**************");

		// 客户端拿到Server的代理对象
		MyBusiness proxy = (MyBusiness) RPC.getProxy(MyBusiness.class,
				             MyBusiness.versionID, 
				             new InetSocketAddress("localhost", 8888), 
				             new Configuration());
		
		
		//调用proxy访问server端的应用
		System.out.println(proxy.sayHello("Tom"));
	}
}












