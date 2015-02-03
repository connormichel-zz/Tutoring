package General;

import java.util.Scanner;

public class RPS {

	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);

		final int SCISSOR = 0;
		final int ROCK = 1;
		final int PAPER = 2;

		int pCount = 0;
		int cCount = 0;

		while (pCount < 2 && cCount < 2){
			
			System.out.println ("Computer count: " + cCount + " " + "Player Count: "  + pCount);

			System.out.print("Scissor (0), ROCK(1), PAPER(2): ");
			int user = input.nextInt();

			int comp = (int)(Math.random()* 3); 

			switch(comp)
			{
			case SCISSOR: 
				if (user == ROCK)
				{
					System.out.println("The computer is SCISSOR. You are ROCK. You won");
					pCount++;
				} 
				else if(user == PAPER)
				{
					System.out.println("The computer is SCISSOR. You are PAPER. You lose");
					cCount++;
				}
				else 
					System.out.println("The computer is SCISSOR. You are SCISSOR. It is a draw");
				break;

			case ROCK:
				if(user == PAPER)
				{
					System.out.println("The computer is ROCK. You are PAPER. You won");
					pCount++;
				}
				else if(user == SCISSOR)
				{
					System.out.println("The computer is ROCK. You are SCISSOR. You lose");
					cCount++;
				}
				else
					System.out.println("The computer is ROCK. You are ROCK. It is a draw");
				break;  

			case PAPER:
				if(user == SCISSOR) 
				{
					System.out.println("The computer is PAPER. You are SCISSOR. You won");
					pCount++;
				}
				else if(user == ROCK) 
				{
					System.out.println("The computer is PAPER. You are ROCK. You lose");
					cCount++;
				}
				else
					System.out.println("The computer is PAPER. You are PAPER. It is a draw");
				break;
			}
		}
	}
} 


