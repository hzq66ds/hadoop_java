package rpc.rpc.server;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface MyBusiness extends VersionedProtocol {

	//�����Լ���ID
	public static long versionID = 1;
	
	//�����ķ���
	public String sayHello(String name);
}
