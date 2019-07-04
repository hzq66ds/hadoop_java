package rpc.rpc.server;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;

public class RPCServer {

	public RPCServer() throws Exception{
		//构造RPC Server
		RPC.Builder builder = new RPC.Builder(new Configuration());
		
		//指定监听地址和端口
		builder.setBindAddress("localhost");
		builder.setPort(8888);
		
		//绑定程序
		builder.setProtocol(MyBusiness.class);
		builder.setInstance(new MyBusinessImpl());
		
		//创建Server并启动
		Server server = builder.build();
		server.start();
	}
	
	public static void main(String[] args) throws Exception {
		new RPCServer();
	}
}










