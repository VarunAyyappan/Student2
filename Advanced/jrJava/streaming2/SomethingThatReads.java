package jrJava.streaming2;

import java.io.*;

public class SomethingThatReads {

	public static void main(String[] args) throws IOException {

		InputStream is = new FileInputStream("jrJava/streaming2/sample.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String line1 = br.readLine();

		while(line1 != null) {
			System.out.println(line1);
			line1 = br.readLine();
		}

		br.close();

	}

}
