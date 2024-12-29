
public class Fast {
	StatsPay check = new StatsPay();
	
	public Fast(){
		RunnerCasino.bet = 10;
		
	}
	
	public void card() {
		int position = (int)(Math.random()*44);
		if( position%11 == RunnerCasino.num) {
			RunnerCasino.wins++;
		}
	}
	
	public void coin() {
		int heads = 0;
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
		int sum = (int)((Math.random()*6)+1) + (int)((Math.random()*6)+1) - 2;
		if(sum == RunnerCasino.num) {
			RunnerCasino.wins++;
		}
	}
	
	public void spinner() {
		int land = (int)(Math.random()*11);
		if(land == RunnerCasino.num) {
			RunnerCasino.wins++;
		}
	}
	
	public void update() {
		check.update();
	}
}
