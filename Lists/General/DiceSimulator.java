package General;

import java.util.*;

public class DiceSimulator {
	private final int[] diceRollValues;
	private final List<Die> dice;
	private final int trials;

	public DiceSimulator(int diceUsed, int trials) throws IllegalArgumentException {
		if(diceUsed < 1 || trials < 1)
			throw new IllegalArgumentException();
		this.trials = trials;
		dice = new ArrayList<Die>();
		diceRollValues = new int[(diceUsed * 6) + 1];
		for (int i = 0; i < diceUsed; i++)
			dice.add(new Die());
	}
	
	public void run() {
		for (int i = 0; i < trials; i++) {
			int sum = 0;
			for (Die d : dice) {
				int roll = d.dieRoll();
				sum += roll;	
			}			
			diceRollValues[sum]++;
		}	
	}
	public void display() {
		int max = 0;
		for (int value : diceRollValues) {
			if (value > max) {
				max = value;
			}
		}
		System.out.println("Value" + "\t" + "Count" + "\t" + "Percent" + "\t" + "Histogram");
		for (int i = dice.size(); i < diceRollValues.length; i++)
			System.out.println(i + "\t" + diceRollValues[i] + "\t" + (100.0 * diceRollValues[i]/trials) + "\t" + stars((double)diceRollValues[i]/max));

	}
	
	public String stars(double ratio) {
		double numOfStars = ratio * 50;
		String stars = "";
		for (int i = 0; i < numOfStars; i++) {
			stars += "*";
		}
		return stars;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Number of dice and trials (enter two integers): ");
		int dice = input.nextInt();
		int trials = input.nextInt();
		DiceSimulator die = new DiceSimulator(dice, trials);
		input.close();
		System.out.println("Throwing " + dice + " die " + trials + " times");
		die.run();
		die.display();
	}
	
	private class Die {
		private final Random rand = new Random();

		public int dieRoll() {
			int roll = rand.nextInt(6) + 1;
			return roll;
		}
	}
}