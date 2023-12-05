package adminSystem;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import middlewareSystem.ServerRecieveClientRequest;
import modelSystem.connector.ReadProductClient;

public class AdminServer {
	public void startServer() throws Exception {
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		server.createContext("/test1", new MyHandler1());
		server.createContext("/test2", new MyHandler2());
		server.setExecutor(Executors.newCachedThreadPool());
		server.start();
	}

	static class MyHandler1 implements HttpHandler {
		public void handle(HttpExchange exchange) throws IOException {
			System.out.println("Handler1");
			Map<String, String> parms = queryToMap(exchange.getRequestURI().getQuery());
			System.out.println("Handler1.1");
			ServerRecieveClientRequest connect = new ServerRecieveClientRequest();
			System.out.println("Handler1.2");
			String output = connect.communicate(parms.get("p1"), parms.get("p2"));
			System.out.println("Handler1.3");
			
			String response = "Hello World! " + "P1 was: " + parms.get("p1") + " and p2 was: " + parms.get("p2");
			exchange.sendResponseHeaders(200, output.length());
			OutputStream os = exchange.getResponseBody();
			os.write(output.getBytes());
			//try {
			//	wait(1000);
			//} catch (InterruptedException e) {
			//	// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}
			//response = " FOO";
			//exchange.sendResponseHeaders(200, output.length());
			//OutputStream os2 = exchange.getResponseBody();
			//os2 = exchange.getResponseBody();
			//os2.write(output.getBytes());
			os.close();
			//os2.close();
		}
	}
	
	
	static class MyHandler2 implements HttpHandler {
		public void handle(HttpExchange exchange) throws IOException {
			Map<String, String> parms = queryToMap(exchange.getRequestURI().getQuery());
			
			ReadProductClient connect = new ReadProductClient();
			String stringList = String.join(" ", connect.read());
			exchange.sendResponseHeaders(200, stringList.length());
			OutputStream os = exchange.getResponseBody();
			os.write(stringList.getBytes());
			os.close();
		}
	}

	public static Map<String, String> queryToMap(String query){

	    Map<String, String> result = new HashMap<String, String>();
	    for (String param : query.split("&")) {
	        String pair[] = param.split("=");
	        if (pair.length>1) {
	            result.put(pair[0], pair[1]);
	        }else{
	            result.put(pair[0], "");
	        }
	    }
	    return result;
	  }
}
