package jrJava.streaming2;

import java.io.*;

public class SomethingThatWritesWhatIType {

	public static void main(String[] args) throws IOException {

		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		OutputStream os = new FileOutputStream("jrJava/streaming2/diary.docx"); // or .txt
		OutputStreamWriter osw = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osw);

		System.out.println("Type about your life today. Type qqqqq and press enter to quit.");
		String line, terminalSeq = "qqqqq";
		while(true) {
			line = br.readLine();
			if(line.startsWith(terminalSeq)) break;
			System.out.println(line);
			pw.println(line);
		}

		br.close();
		pw.flush();
		pw.close();

	}

}
