package rpc.rpc.server;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;

public class RPCServer {

	public RPCServer() throws Exception{
		//����RPC Server
		RPC.Builder builder = new RPC.Builder(new Configuration());
		
		//ָ��������ַ�Ͷ˿�
		builder.setBindAddress("localhost");
		builder.setPort(8888);
		
		//�󶨳���
		builder.setProtocol(MyBusiness.class);
		builder.setInstance(new MyBusinessImpl());
		
		//����Server������
		Server server = builder.build();
		server.start();
	}
	
	public static void main(String[] args) throws Exception {
		new RPCServer();
	}
}










