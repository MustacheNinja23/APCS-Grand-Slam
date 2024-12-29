
//import java.util.Scanner;

public class Slow {
	
	//Scanner board = new Scanner(System.in);
	StatsPay check = new StatsPay();
	int heads, sum, land;
	String card;
	
	public Slow() {
		/*
		System.out.println("How much would you like to bet? (Only multiples of 10 up to 50)");
		RunnerCasino.bet = board.nextInt();
		System.out.println("What number would you like to bet on?");
		RunnerCasino.num = board.nextInt();
		*/
	}
	
	public void card() {
		//0 - 10 for each suit: 0 = Jack && 1 = Ace: Letter represents suit
		String[] cards = {"JH","AH","2H","3H","4H","5H","6H","7H","8H","9H","10H","JD","AD","2D","3D","4D","5D","6D","7D","8D","9D","10D",
				"JC","AC","2C","3C","4C","5C","6C","7C","8C","9C","10C","JS","AS","2S","3S","4S","5S","6S","7S","8S","9S","10S"};
		int position = (int)(Math.random()*44);
		card = cards[position];
		if( position%11 == RunnerCasino.num) {
			RunnerCasino.wins++;
		}
		
	}
	
	public void coin() {
		//flips 10 times, counts number of heads
		heads = 0;
		for(int i = 0; i < 10; i++) {
			if(Math.random() < 0.5) {
				heads++;
			}
		}
		if(heads == RunnerCasino.num) {
			RunnerCasino.wins++;
		}
	}
	
	public void dice() {
		//rolls 2 dice
		sum = (int)((Math.random()*6)+1) + (int)((Math.random()*6)+1) - 2;
		if(sum == RunnerCasino.num) {
			RunnerCasino.wins++;
		}
		
	}
	
	public void spinner() {
		//spins from 0 - 10
		land = (int)(Math.random()*11);
		if(land == RunnerCasino.num) {
			RunnerCasino.wins++;
		}
		
	}
	
	public void show() {
		check.update();
		CasinoGUI.setOutput("The card is the " + card
				+ "\nOf 10 coins, " + heads + " landed on heads"
				+ "\nThe dice sum to " + sum
				+ "\nThe spinner landed on " + land
				+ "\nYou won " + RunnerCasino.wins + " time(s)" 
				+ "\n$" + check.checkPay());
	}
	
}
