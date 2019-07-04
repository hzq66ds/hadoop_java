package rpc.rpc.server;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface MyBusiness extends VersionedProtocol {

	//申明自己的ID
	public static long versionID = 1;
	
	//发布的方法
	public String sayHello(String name);
}
