package General;

import java.net.URL;
import java.util.Scanner;
import java.io.InputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class URLReader {

	private ArrayList<String> list = new ArrayList<String>();
	private final String domainName;
	public URLReader(String file) throws IOException,MalformedURLException{
		domainName = file;
		String domain = "http://" + file + "/robots.txt";
		URL path = new URL(domain);
		InputStream fileReader = path.openStream();
		Scanner scan = new Scanner(fileReader);
		while(scan.hasNextLine()){
			list.add(scan.nextLine());
		}
		scan.close();
	}
	public void write(PrintStream text){
		for(String file : list){
			text.println(file);
		}
	}
	public void run() throws FileNotFoundException{
		write(System.out);
		PrintStream out = new PrintStream(new FileOutputStream("robots.txt"));
		write(out);
		out.close();
	}
	public String toString(){
		return domainName;
	}
	public static void main(String[] args){
		try{
			URLReader file = new URLReader("www.umbc.edu");
			System.out.println(file);
			file.run();
		}
		catch(FileNotFoundException e){
			System.out.println("File Not Found.");
		}
		catch(MalformedURLException y){
			System.out.println("Malformed URL has occurred.");
		}
		catch(IOException x){
			System.out.println("IO Exception has occurred.");
		}

	}	

}//end class
