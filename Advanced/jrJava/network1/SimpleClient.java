package jrJava.network1;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {

	public static void main(String[] args) throws Exception {

		Socket s = new Socket("localhost", 5454); 
		//192.168.1.34 or 18, localhost

		OutputStream os = s.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osw);

		for(int i=0;i<100;i++)
			pw.println("Get raided by 4chan/pol/!");

		pw.flush();
		pw.close();

	}


}
