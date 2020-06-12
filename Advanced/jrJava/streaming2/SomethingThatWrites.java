package jrJava.streaming2;

import java.io.*;

public class SomethingThatWrites {

	public static void main(String[] args) throws IOException {
		
		OutputStream os = new FileOutputStream("jrJava/streaming2/output.docx");  //.txt
		OutputStreamWriter osw = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osw);
		
		pw.write("Today is better than yesterday.\n");
		pw.write("About 10 degrees cooler.");
		pw.flush();
		pw.close();

		/*
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write("Today is better than yesterday.\n");
		bw.write("About 10 degrees cooler.");
		bw.flush();
		bw.close();
		*/

	}

}
