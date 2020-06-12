package jrJava.streaming1;

import java.io.*;

public class ByteCopier {

	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("jrJava/streaming1/sample.txt");
		OutputStream os1 = new FileOutputStream("jrJava/streaming1/sample2.txt");
		OutputStream os2 = new FileOutputStream("jrJava/streaming1/sample3.txt");
		OutputStream os3 = new FileOutputStream("jrJava/streaming1/sample4.txt");
		byte[] bucket = new byte[400];
		int numOfBytesRead, total=0;
		
		while(true) {
			numOfBytesRead = is.read(bucket);
			if(numOfBytesRead<=0) break;
			total+=numOfBytesRead;
			os1.write(bucket, 0, numOfBytesRead);
			os2.write(bucket, 0, numOfBytesRead);
			os3.write(bucket, 0, numOfBytesRead);
		}
		System.out.println(total);
		is.close();
		os1.flush();
		os1.close();
		os2.flush();
		os2.close();
		os3.flush();
		os3.close();
	}

}
