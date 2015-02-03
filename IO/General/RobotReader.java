package General;

//File name is robots.txt

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class RobotReader {

	private ArrayList<String> list = new ArrayList<String>();

	public RobotReader(String path) throws FileNotFoundException
	{ 

		Scanner in = new Scanner(new FileInputStream(path));
		while(in.hasNextLine())
		{
			list.add(in.nextLine());
		}
		in.close();
	}//end constructor

	public void find(String a)
	{
		finder(a, 0);

	}//end find  

	public void finder(String a, int lineNum)
	{
		if (lineNum == list.size()){
			return;
		}
		else if (list.get(lineNum).contains(a)){
			System.out.println("Line " + lineNum + " contains " +  a);
		}
		lineNum++;
		finder(a, lineNum);

	}//end finder

	public static void main(String[] args)
	{
		try
		{ 
		System.out.print("Enter path to file: ");
		Scanner a = new Scanner(System.in);

		RobotReader read = new RobotReader(a.next());

		String input = "";
		while(!(input).equals("q")){
			System.out.print("Word to find('q' to quit): ");
			input=a.next();
			read.find(input);
		}
		}//end try

		catch (FileNotFoundException fe)
		{
			System.out.println("File not found");
		}//end catch 


	}//end main


}
