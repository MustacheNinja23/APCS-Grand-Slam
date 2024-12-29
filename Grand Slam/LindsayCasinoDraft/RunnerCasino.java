
import java.util.Scanner;

public class RunnerCasino {
	public static int runs, wins = 0, bet, num;
	public static double totalbet, totalwon, totalwins;
	private static String mode = "";

	public static void main(String[] args) {
		Scanner board = new Scanner(System.in);
		StatsPay check = new StatsPay();
		String redo = "";
		
		if(mode.equals("")) {
			System.out.println("Slow mode will run 10 times, and will allow player input."
					+ "\nFast mode will run a set number of times with no input, and 10$ bets for each game" + 
					"\nWhich mode would you like to play?");
			mode = board.next();
		}
		
		if (mode.equals("slow")) {
			runs = 10;
			for(int i = 0; i < 10; i++) {
				Slow slow = new Slow();
				slow.card();
				slow.coin();
				slow.dice();
				slow.spinner();
				slow.show();
				wins = 0;
			}
			System.out.println("You won a total of " + totalwins + " times, for an average of " + 
					check.getAvgWins() + " wins per game");
			System.out.println("You bet a total of $" + totalbet + " and won a total of $" + 
					totalwon + ", for an expected value of " + check.getExVal());
		}
		
		else if(mode.equals("fast")) {
			System.out.println("How many times would you like to play?");
			runs = board.nextInt();
			Fast fast = new Fast();
			for(int j = 0; j < runs; j++) {
				fast.card();
				fast.coin();
				fast.dice();
				fast.spinner();
				fast.update();
				wins = 0;
			}
			System.out.println("\nYou won a total of " + totalwins + " times, for an average of " + 
					check.getAvgWins() + " wins per game");
			System.out.println("You bet a total of $" + totalbet + " and won a total of $" + 
					totalwon + ", for an expected value of " + check.getExVal());
			
			System.out.println("\nWould you like to run fast mode again? (Final stats will include previous runs)");
			redo = board.next();
			if(redo.equals("yes")) {
				RunnerCasino.main(args);
			}
		}
	}

}
