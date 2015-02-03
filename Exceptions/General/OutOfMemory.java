package General;

public class OutOfMemory {

	public static void main(String[] args){
		try
		{
			int[] veryLargeArray = new int[2000000000];
		}
		catch(OutOfMemoryError e)
		{
			e.printStackTrace();
			System.out.println("You have run out of memory.");
			System.out.println("Goodbye.");
		}
	}
}
