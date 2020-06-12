package jrJava.network1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) throws Exception {

		ServerSocket ss = new ServerSocket(5454);
		Socket s = ss.accept();

		InputStream is = s.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line = br.readLine();

		while(line != null) {
			System.out.println("Received: "+line);
			line = br.readLine();
		}
		System.out.println("Done!");
		br.close();

	}

}
