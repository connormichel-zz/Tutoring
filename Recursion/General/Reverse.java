package General;

public class Reverse {

	public static void main(String[] args) {
		System.out.println(recips(0));
		System.out.println(recips(4));
		System.out.println(recips(10));

		char[] data = {'a', 'b', 'c', 'd', 'e', 'f'};
		reverse(data, 0, 5);
		show(data, "0, 5");
		reverse(data, 3, 2);
		show(data, "3, 2");
		reverse(data, 2, 3);
		show(data, "2, 3");
		reverse(data, 5, 8);
		show(data, "5, 8");
	} // main()

	private static void show(char[] data, String label) {

		System.out.print(label + ": ");
		for (char ch: data)
			System.out.print(ch);

		System.out.println();

	} // show()

	public static double recips(int n){
		if(n == 1){
			return n;
		}
		if(n<0){
			throw new IllegalArgumentException("Less than one");
		}
		if(n==0){
			return 0;
		}
		double m = n;
		double value = (1/m);
		return value + recips(n-1); 
	}

	public static void reverse(char[] data, int m, int n){
		if (m>=n){
			return;
		}
		if(m > data.length || n > data.length || m < 0 || n < 0 ){
			throw new IllegalArgumentException("Out of bounds");
		}			  
		char temp = data[m];
		data[m] = data[n];
		data[n] = temp;
		reverse(data,m+1,n-1);
	}

}
