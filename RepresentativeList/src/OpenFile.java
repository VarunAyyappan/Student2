/**
 * Utilities for opening a text file.  The text file
 * can be opened and read from, or the file can be
 * opened (created) and written to.
 * @author   Varun Ayyappan
 * @version  1.0
 * @since    8/22/2017
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OpenFile
{
	public static void main(String [] args)
	{
		Scanner infile = OpenFile.openToRead("g.txt");
		PrintWriter outfile = OpenFile.openToWrite("g2.txt");
		String temp = null;
		while(infile.hasNext())
		{
			temp = infile.nextLine();
			System.out.println(temp);
			outfile.println(temp);
		}
		infile.close();
		outfile.close();
	}
	
	/**
	 * Opens a file for reading.
	 *
	 * @param filestring   The name of the file to be opened.
	 * @return             A Scanner instance of the file to be opened.
	 */
	public static Scanner openToRead (String filestring)
	{		
		Scanner fromFile = null;
		File fileName = new File(filestring);
		
		try
		{
			return fromFile = new Scanner(fileName);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("\n\nSorry, but the " + filestring +  " file wasn't found.\n\n");
			System.exit(1);
		}
		
		return fromFile;
	}
	
	/**
	 * Opens a file for writing.
	 *
	 * @param filestring   The name of the file to be opened (created).
	 * @return             A PrintWriter instance of the file to be opened (created).
	 */
	public static PrintWriter openToWrite (String filestring)
	{
		PrintWriter outFile = null;
		try
		{
			return outFile = new PrintWriter(filestring);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("\n\nSorry, but the " + filestring +  " file was found.\n\n");
			System.exit(1);
		}
		
		return outFile;
	}
}