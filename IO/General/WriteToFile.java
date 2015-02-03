package General;

import java.io.*;

public class WriteToFile {

	public static void main(String[] args) throws IOException{
		File file = new File("/Users/Connor/Documents/WriteToFile.txt");
		PrintWriter writer = new PrintWriter(file);
		writer.println("The quick brown fox jumps over the lazy dog.");
		writer.close();
	}
}
