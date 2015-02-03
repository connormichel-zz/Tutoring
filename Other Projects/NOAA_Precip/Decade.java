package NOAA_Precip;

import java.text.DecimalFormat;
public class Decade implements Comparable <Decade>{
	double decadePrecip;
	int decadeYears;
	Year[] x;
	int first;
	int last;

	public Decade (Year[] x, int first, int last){
		this.x= x;
		this.first=first;
		this.last=last;
	}

	public double mean(){
		int count =0;
		double sum = 0;

		for(int i =first; i<=last; i++){
			sum += x[i].getterpr();
			count++;
		}
		double mean= sum/count;
		return mean;
	}

	public int compareTo (Decade other){
		if(this.mean()>other.mean())
			return 1;
		else if(this.mean()==other.mean())
			return 0;
		else
			return -1;
	}

	public String toString(){
		DecimalFormat fmt = new DecimalFormat("0.00");
		String t = x[first].year() +": "+ fmt.format( mean()) + "\" average per year" ;
		return t;
	}
}




