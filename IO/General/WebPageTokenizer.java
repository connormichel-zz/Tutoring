package General;

import java.util.*;
import java.io.*;
import java.net.*;


public class WebPageTokenizer implements Iterable<String> {

	int numTokens;
	final Scanner scan;
	final Set<String> set;

	public WebPageTokenizer(String theURL) throws IOException, MalformedURLException {

		set = new HashSet<String>();

		final URL url = new URL(theURL);
		scan = new Scanner(url.openStream());

		numTokens = 0;

		System.out.println(url + " is being opened");

	}

	public void readTokens() {

		while(scan.hasNext()) {
			numTokens++;
			String token = scan.next();
			set.add(token);
		}
		scan.close();
	}

	public void writeTokens(String outputFile) throws FileNotFoundException {


		PrintStream stream = new PrintStream(outputFile);

		for(String token: set) {
			stream.println(token + "\n");
		}

		stream.close();

		System.out.println("Writing to " + outputFile + "\n");
	}

	public Iterator<String> iterator() {

		return set.iterator();

	}

	@Override
	public String toString(){
		return "Number of tokens read: " + numTokens + ", number of tokens in the set: " + set.size();
	}


	public static String urlToFileName(String url) {

		if(url.length() == 0 || url.charAt(url.length() - 1) == '/') {
			return "index.html";
		}

		int lastSlash = url.lastIndexOf('/');
		return url.substring(lastSlash + 1);

	}//urlToFileName()

	public static void main(String[] args) {

		try {
			WebPageTokenizer obj1 = new WebPageTokenizer("ftp://aftp.cmdl.noaa.gov/products/trends/co2/co2_mm_mlo.txt");
			obj1.readTokens();
			System.out.println(obj1.toString());
			obj1.writeTokens(urlToFileName("ftp://aftp.cmdl.noaa.gov/products/trends/co2/co2_mm_mlo.txt"));

			WebPageTokenizer obj2 = new WebPageTokenizer("http://headers.cloxy.net/request.php");
			obj2.readTokens();
			System.out.println(obj2.toString());
			obj2.writeTokens(urlToFileName("http://headers.cloxy.net/request.php"));

			WebPageTokenizer obj3 = new WebPageTokenizer("https://userpages.umbc.edu/~jmartens/clientIP.php");
			obj3.readTokens();
			System.out.println(obj3.toString());
			obj3.writeTokens(urlToFileName("https://userpages.umbc.edu/~jmartens/clientIP.php"));

		}
		catch(MalformedURLException ex){
			System.out.println("MalformedURLException Found");
		}
		catch(FileNotFoundException ex){
			System.out.println("FileNotFoundException Found");
		}
		catch(IOException ex){
			System.out.println("IOException Found");
		}


	}


}