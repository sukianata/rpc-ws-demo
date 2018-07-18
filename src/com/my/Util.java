package com.my;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class Util {

	/**
	 * 
	 * @Description: rpc 調用 webservice
	 * @param url webservice地址
	 * @return Object[]  
	 * @date 2018/7/18
	 */
	public static Object[] callWS(String url) {
		Object[] response=null;
		try {
			RPCServiceClient client=new RPCServiceClient();
			//Get the basic client configuration from this service interaction.
			Options options=client.getOptions();
			//establish the remote address
			EndpointReference point=new EndpointReference(url);
			//set the address to options
			options.setTo(point);
			//Set WS-Addressing Action / SOAP Action string.
			//eg:options.setAction("命名空間/WS方法名");
			options.setAction("");
			String[] params=new String[]{};
			response=client.invokeBlocking(new QName("SERVICE_NAMESPACE","serviceName"), params, new Class[]{String.class});
			
		} catch (AxisFault e) {
			e.printStackTrace();
		}
		return response;
	}
}
