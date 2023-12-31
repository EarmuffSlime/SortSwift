package client;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class ClientCaller {
	
	public ClientCaller() {
		
	}
	
	public String doThehttpCall1(String p1, String p2) {

		String urlString = String.format(
				"http://localhost:8000/test1?p1=%s&p2=%s", p1, p2);
		
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode == 200) {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				return inline;
			}

		} catch (IOException e) {
			System.out.println(e);
			System.out.println("Something went wrong with the API call.");
		}
		return null;
	}
	
	public String doThehttpCall2(String p3) {

		String urlString = String.format(
				"http://localhost:8000/test2?p3=%s", p3);
		
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode == 200) {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				return inline;
			}

		} catch (IOException e) {
			System.out.println(e);
			System.out.println("Something went wrong with the API call.");
		}
		return null;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClientCaller aCaller = new ClientCaller();
		System.out.println("The server responed : " + aCaller.doThehttpCall1("Param1value", "Param2value"));

	}

}
