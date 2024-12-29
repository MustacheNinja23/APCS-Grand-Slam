//Commented out code is what was used for the draft, all code has been updated for the GUI version
//It looks like a mess with the comments but thats ok
//import java.util.Scanner;

import java.text.DecimalFormat;

public class RunnerCasino{
	public static int runs = 0, wins = 0, bet, num, totalruns;
	public static int totalbet, totalwon, totalwins;
	public static String mode = "";

	public void runCasino() {
		//Scanner board = new Scanner(System.in);
		StatsPay check = new StatsPay();
		//https://mkyong.com/java/java-display-double-in-2-decimal-points/
		DecimalFormat df = new DecimalFormat("0.00");
		//String redo = "";
		/*
		if(mode.equals("")) {
			System.out.println("Welcome to Grand Slam!"
					+ "\nFor each game, the player will need to bet on a number. "
					+ "\nThere will then be one game at each \"base\" (Cards, Coins, Dice, and Spinner),"
					+ "\n and if your number is the same as the result of the game, you will win once for up to four wins."
					+ "\n Each win will increase your earnings in that game."
					+ "\nSlow mode will run 10 times, and will allow player input."
					+ "\nFast mode will run a set number of times with no input, and 10$ bets for each game" + 
					"\nWhich mode would you like to play?");
			mode = board.next();
		}
		*/
		/*to-do for slow mode
		 * inputs for bet number and amount
		 * panel-in-panel for all 10 games
		 * real-time output?
		 */
		if (mode.equals("slow") || mode.equals("Slow")) {
			/*
			runs = 10;
			for(int i = 0; i < runs; i++) {
				Slow slow = new Slow();
				slow.card();
				slow.coin();
				slow.dice();
				slow.spinner();
				slow.show();
				wins = 0;
			}
			*/
			runs++;
			totalruns += runs;
			Slow slow = new Slow();
			slow.card();
			slow.coin();
			slow.dice();
			slow.spinner();
			slow.show();
			wins = 0;
			/*
			System.out.println("You won a total of " + totalwins + " times, for an average of " + 
					check.getAvgWins() + " wins per game");
			System.out.println("You bet a total of $" + totalbet + " and won a total of $" + 
					totalwon + ", for an expected value of " + check.getExVal());
			*/
		}
		
		else if(mode.equals("fast") || mode.equals("Fast")) {
			//System.out.println("How many times would you like to play?");
			//runs = board.nextInt();
			totalruns += runs;
			Fast fast = new Fast();
			for(int j = 0; j < runs; j++) {
				fast.card();
				fast.coin();
				fast.dice();
				fast.spinner();
				fast.update();
				wins = 0;
			}
			CasinoGUI.setOutput("\nYou played a total of " + totalruns + " times, won a total of " + totalwins + " times, for an average of " 
				+ df.format(check.getAvgWins()) + " wins per game." + "\nYou bet a total of $" + totalbet + " and won a total of $" + totalwon + 
				", for an expected value of " + df.format(check.getExVal()) + ".");
			
			//
			/*
			System.out.println("\nWould you like to run fast mode again? (Final stats will include previous runs)");
			redo = board.next();
			if(redo.equals("yes")) {
				runCasino();
			}
			*/

}
	}

}
