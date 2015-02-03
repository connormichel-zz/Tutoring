package General;

//File name is r.txt

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCounter {

	public static void main(String args[]) throws IOException {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter file path: ");
		String filename = input.next(); 
		FileInputStream file = new FileInputStream(filename);

		Scanner filereader = new Scanner(file);

		int lineCount = 0;
		int charCount = 0;
		int wordCount = 0;

		while (filereader.hasNextLine())
		{
			lineCount++;
			String line = filereader.nextLine();

			charCount += line.length();
			Scanner wordreader = new Scanner(line);

			while(wordreader.hasNext())
			{
				wordreader.next();
				wordCount++;
			}

		}
		System.out.println("The file has " + lineCount + " lines, " + wordCount + " words, and " +
				charCount + " characters.");
	}
}

