//stats & payouts
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
		return (double)RunnerCasino.totalwins/RunnerCasino.runs;
	}
	
	public double getExVal() {
		return ((double)RunnerCasino.totalwon - RunnerCasino.totalbet)/RunnerCasino.totalruns;
	}
	
	public double checkPay() {
		//$10 added to every prize to account for money spent
		double[] payouts = 
				//5
				{0,20.00,20.00,50.00,210.00,
				//4 & 6
				0,20.00,30.00,60.00,1010.00,
				//3 & 7
				0,20.00,50.00,260.00,4710.00,
				//2 & 8
				0,30.00,60.00,360.00,9010.00,
				//1 & 9
				0,40.00,70.00,450.00,15010.00,
				//0 & 10
				0,40.00,160.00,18010.00,500010.00};
		return (RunnerCasino.bet/10.0)*payouts[RunnerCasino.wins + 5*Math.abs(5-RunnerCasino.num)];
	}
}
