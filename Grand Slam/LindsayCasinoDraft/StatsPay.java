
public class StatsPay {
	
	public void update() {
		RunnerCasino.totalbet += RunnerCasino.bet;
		RunnerCasino.totalwins += RunnerCasino.wins;
		RunnerCasino.totalwon += checkPay();
	}
	
	public double getTotal() {
		return RunnerCasino.totalwon;
	}

	public double getAvgWins() {
		return RunnerCasino.totalwins/RunnerCasino.runs;
	}
	
	public double getExVal() {
		return (RunnerCasino.totalwon - RunnerCasino.totalbet)/RunnerCasino.runs;
	}
	
	public double checkPay() {
		double[] payouts = 
				//5
				{-10.00,10.00,10.00,40.00,200.00,
				//4 & 6
				-10.00,10.00,20.00,50.00,1000.00,
				//3 & 7
				-10.00,10.00,40.00,250.00,4700.00,
				//2 & 8
				-10.00,20.00,50.00,350.00,9000.00,
				//1 & 9
				-10.00,30.00,60.00,440.00,15000.00,
				//0 & 10
				-10.00,30.00,150.00,18000.00,500000.00};
		return (RunnerCasino.bet/10)*payouts[RunnerCasino.wins + 5*Math.abs(5-RunnerCasino.num)];
	}
}
