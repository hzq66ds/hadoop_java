package rpc.rpc.server;

import java.io.IOException;

import org.apache.hadoop.ipc.ProtocolSignature;

public class MyBusinessImpl implements MyBusiness {

	public String sayHello(String name) {
		System.out.println("************ RPC Server**************");
		
		return "Hello  " + name; 
	}

	public ProtocolSignature getProtocolSignature(String arg0, long arg1,
			int arg2) throws IOException {
		// TODO Auto-generated method stub
		return new ProtocolSignature(MyBusiness.versionID, null);
	}

	public long getProtocolVersion(String arg0, long arg1) throws IOException {
		//·µ»ØID
		return MyBusiness.versionID;
	}
}





