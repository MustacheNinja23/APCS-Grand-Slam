//used existing runner method, probably didn't need to
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import java.awt.BasicStroke;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class CasinoGUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel menuPanel;
	Color back = new Color(84,118,68);
	public static String output = "";
	private JTextField fastRuns;
	RunnerCasino run = new RunnerCasino();
	private JTextField fastBetOn;
	private int slow = 1;
	DecimalFormat df = new DecimalFormat("0.00");
	StatsPay check = new StatsPay();
	private JTextField slowBetOn;
	private JTextField slowAmountBet;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CasinoGUI frame = new CasinoGUI();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Creates the frame.
	 * adds all individual elements of the GUI
	 */
	public CasinoGUI() {
		super("CasinoGUI");
		
		JFrame frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 701);
		setTitle("Grand Slam");
		menuPanel = new JPanel();
		menuPanel.setBackground(new Color(84, 118, 68));
		menuPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(menuPanel);
		menuPanel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setVisible(false);
		tabbedPane.setBounds(-10, -33, 720, 718);
		tabbedPane.setBackground(new Color(84,118,68));
		menuPanel.add(tabbedPane);
		
		JPanel rulesPanel = new JPanel();
		tabbedPane.addTab("Rules", null, rulesPanel, null);
		rulesPanel.setBackground(new Color(84,118,68));
		rulesPanel.setLayout(null);
		
		JLabel rulesTitle = new JLabel("Rules");
		rulesTitle.setFont(new Font("Mukta Mahee", Font.PLAIN, 76));
		rulesTitle.setBounds(265, 24, 170, 74);
		rulesPanel.add(rulesTitle);
		
		JTextPane txtpnWelcomeToGrand = new JTextPane();
		txtpnWelcomeToGrand.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtpnWelcomeToGrand.setEditable(false);
		txtpnWelcomeToGrand.setAlignmentX(Component.CENTER_ALIGNMENT);
		txtpnWelcomeToGrand.setBackground(new Color(84, 118, 68,150));
		txtpnWelcomeToGrand.setText("Welcome to Grand Slam!\nFor each game, the player will need to bet on a number, 0-10 (inclusive)."
				+ "\nThere will then be one game at each \"base\" (Cards, Coins, Dice, and Spinner),"
				+ "\nand if your number is the same as the result of the game, you will win once for up to four wins."
				+ "\nEach win will increase your earnings in that game.\nSlow mode will run 10 times, and will allow player input including bets and number bet on for each game."
				+ "\nFast mode will run a set number of times with the same number bet on for all games, and $10 bets for each game"
				+ "\nThe game will reset upon exiting a window.");
		txtpnWelcomeToGrand.setBounds(52, 132, 617, 210);
		rulesPanel.add(txtpnWelcomeToGrand);
		
		JButton rulesBack = new JButton("Back");
		rulesBack.setBounds(297, 618, 117, 29);
		rulesPanel.add(rulesBack);
		
		Bases bases_1 = new Bases();
		bases_1.setLayout(null);
		bases_1.setBackground(back);
		bases_1.setBounds(0, -70, 701, 701);
		rulesPanel.add(bases_1);
		
		JPanel slowPanel = new JPanel();
		tabbedPane.addTab("New tab", null, slowPanel, null);
		slowPanel.setBackground(back);
		slowPanel.setLayout(null);
		
		JLabel slowTitle = new JLabel("Slow Mode");
		slowTitle.setFont(new Font("Mukta Mahee", Font.PLAIN, 76));
		slowTitle.setBounds(175, 23, 360, 102);
		slowPanel.add(slowTitle);
		
		JButton slowBack = new JButton("Back");
		slowBack.setBounds(297, 618, 117, 29);
		slowPanel.add(slowBack);
		
		JLabel fastBetOnLabel_1 = new JLabel("# bet on :");
		fastBetOnLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		fastBetOnLabel_1.setBounds(265, 135, 100, 30);
		slowPanel.add(fastBetOnLabel_1);
		
		JTextPane slow1 = new JTextPane();
		slow1.setOpaque(false);
		slow1.setFocusable(false);
		slow1.setFocusTraversalKeysEnabled(false);
		slow1.setFocusCycleRoot(false);
		slow1.setVisible(false);
		slow1.setFont(new Font("Lucida Grande", Font.BOLD, 9));
		slow1.setEditable(false);
		slow1.setBackground(new Color(84, 118, 68, 150));
		slow1.setBounds(34, 210, 117, 102);
		slowPanel.add(slow1);
		
		JTextPane slow2 = new JTextPane();
		slow2.setOpaque(false);
		slow2.setFocusTraversalKeysEnabled(false);
		slow2.setFocusCycleRoot(false);
		slow2.setFocusable(false);
		slow2.setVisible(false);
		slow2.setFont(new Font("Lucida Grande", Font.BOLD, 9));
		slow2.setEditable(false);
		slow2.setBackground(new Color(84, 118, 68, 150));
		slow2.setBounds(163, 210, 117, 102);
		slowPanel.add(slow2);
		
		JTextPane slow3 = new JTextPane();
		slow3.setOpaque(false);
		slow3.setFocusCycleRoot(false);
		slow3.setFocusTraversalKeysEnabled(false);
		slow3.setFocusable(false);
		slow3.setVisible(false);
		slow3.setFont(new Font("Lucida Grande", Font.BOLD, 9));
		slow3.setEditable(false);
		slow3.setBackground(new Color(84, 118, 68, 150));
		slow3.setBounds(292, 210, 117, 102);
		slowPanel.add(slow3);
		
		JTextPane slow4 = new JTextPane();
		slow4.setOpaque(false);
		slow4.setFocusTraversalKeysEnabled(false);
		slow4.setFocusCycleRoot(false);
		slow4.setFocusable(false);
		slow4.setVisible(false);
		slow4.setFont(new Font("Lucida Grande", Font.BOLD, 9));
		slow4.setEditable(false);
		slow4.setBackground(new Color(84, 118, 68, 150));
		slow4.setBounds(421, 210, 117, 102);
		slowPanel.add(slow4);
		
		JTextPane slow5 = new JTextPane();
		slow5.setOpaque(false);
		slow5.setFocusable(false);
		slow5.setFocusCycleRoot(false);
		slow5.setFocusTraversalKeysEnabled(false);
		slow5.setVisible(false);
		slow5.setFont(new Font("Lucida Grande", Font.BOLD, 9));
		slow5.setEditable(false);
		slow5.setBackground(new Color(84, 118, 68, 150));
		slow5.setBounds(550, 210, 117, 102);
		slowPanel.add(slow5);
		
		JTextPane slow6 = new JTextPane();
		slow6.setOpaque(false);
		slow6.setFocusCycleRoot(false);
		slow6.setFocusTraversalKeysEnabled(false);
		slow6.setFocusable(false);
		slow6.setVisible(false);
		slow6.setFont(new Font("Lucida Grande", Font.BOLD, 9));
		slow6.setEditable(false);
		slow6.setBackground(new Color(84, 118, 68, 150));
		slow6.setBounds(34, 320, 117, 102);
		slowPanel.add(slow6);
		
		JTextPane slow7 = new JTextPane();
		slow7.setOpaque(false);
		slow7.setFocusable(false);
		slow7.setFocusTraversalKeysEnabled(false);
		slow7.setFocusCycleRoot(false);
		slow7.setVisible(false);
		slow7.setFont(new Font("Lucida Grande", Font.BOLD, 9));
		slow7.setEditable(false);
		slow7.setBackground(new Color(84, 118, 68, 150));
		slow7.setBounds(163, 320, 117, 102);
		slowPanel.add(slow7);
		
		JTextPane slow8 = new JTextPane();
		slow8.setOpaque(false);
		slow8.setFocusable(false);
		slow8.setFocusTraversalKeysEnabled(false);
		slow8.setFocusCycleRoot(false);
		slow8.setVisible(false);
		slow8.setFont(new Font("Lucida Grande", Font.BOLD, 9));
		slow8.setEditable(false);
		slow8.setBackground(new Color(84, 118, 68, 150));
		slow8.setBounds(292, 320, 117, 102);
		slowPanel.add(slow8);
		
		JTextPane slow9 = new JTextPane();
		slow9.setOpaque(false);
		slow9.setFocusable(false);
		slow9.setFocusTraversalKeysEnabled(false);
		slow9.setFocusCycleRoot(false);
		slow9.setVisible(false);
		slow9.setFont(new Font("Lucida Grande", Font.BOLD, 9));
		slow9.setEditable(false);
		slow9.setBackground(new Color(84, 118, 68, 150));
		slow9.setBounds(421, 320, 117, 102);
		slowPanel.add(slow9);
		
		JTextPane slow10 = new JTextPane();
		slow10.setOpaque(false);
		slow10.setFocusable(false);
		slow10.setFocusTraversalKeysEnabled(false);
		slow10.setFocusCycleRoot(false);
		slow10.setVisible(false);
		slow10.setFont(new Font("Lucida Grande", Font.BOLD, 9));
		slow10.setEditable(false);
		slow10.setBackground(new Color(84, 118, 68, 150));
		slow10.setBounds(550, 320, 117, 102);
		slowPanel.add(slow10);
		
		JTextPane slowRunOutput = new JTextPane();
		slowRunOutput.setOpaque(false);
		slowRunOutput.setFocusable(false);
		slowRunOutput.setFocusTraversalKeysEnabled(false);
		slowRunOutput.setFocusCycleRoot(false);
		slowRunOutput.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		slowRunOutput.setEditable(false);
		slowRunOutput.setVisible(false);
		slowRunOutput.setBackground(new Color(84, 118, 68, 150));
		slowRunOutput.setBounds(160, 427, 391, 123);
		slowPanel.add(slowRunOutput);
		
		JButton runSlow = new JButton("Next");
		runSlow.setBounds(297, 580, 117, 29);
		slowPanel.add(runSlow);
		
		slowBetOn = new JTextField();
		slowBetOn.setBorder(new LineBorder(new Color(0, 0, 0)));
		slowBetOn.setBounds(370, 140, 130, 26);
		slowPanel.add(slowBetOn);
		slowBetOn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Amount Bet : ");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(233, 170, 130, 30);
		slowPanel.add(lblNewLabel);
		
		slowAmountBet = new JTextField();
		slowAmountBet.setBorder(new LineBorder(new Color(0, 0, 0)));
		slowAmountBet.setColumns(10);
		slowAmountBet.setBounds(370, 175, 130, 26);
		slowPanel.add(slowAmountBet);
		
		Bases bases_3 = new Bases();
		bases_3.setLayout(null);
		bases_3.setBackground(new Color(84, 118, 68));
		bases_3.setBounds(0, -70, 701, 701);
		slowPanel.add(bases_3);
		
		JPanel fastPanel = new JPanel();
		tabbedPane.addTab("New tab", null, fastPanel, null);
		fastPanel.setBackground(back);
		fastPanel.setLayout(null);
		
		JLabel fastTitle = new JLabel("Fast Mode");
		fastTitle.setBounds(182, 20, 340, 102);
		fastPanel.add(fastTitle);
		fastTitle.setFont(new Font("Mukta Mahee", Font.PLAIN, 76));
		
		JButton fastBack = new JButton("Back");
		fastBack.setBounds(297, 618, 117, 29);
		fastPanel.add(fastBack);
		
		JLabel runslabel = new JLabel("Number of runs :");
		runslabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		runslabel.setBounds(195, 170, 170, 30);
		runslabel.setBackground(new Color(84,118,68,10));
		fastPanel.add(runslabel);
		
		fastRuns = new JTextField();
		fastRuns.setBorder(new LineBorder(new Color(0, 0, 0)));
		fastRuns.setDisabledTextColor(new Color(228, 229, 231));
		fastRuns.setBackground(new Color(240, 241, 244));
		fastRuns.setBounds(370, 175, 130, 26);
		fastPanel.add(fastRuns);
		fastRuns.setColumns(10);
		
		JButton runFast = new JButton("Run");
		runFast.setBounds(297, 430, 117, 29);
		fastPanel.add(runFast);
		
		JTextPane fastRunOutput = new JTextPane();
		fastRunOutput.setOpaque(false);
		fastRunOutput.setEditable(false);
		fastRunOutput.setAutoscrolls(false);
		fastRunOutput.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		fastRunOutput.setBackground(new Color(84, 118, 68,150));
		fastRunOutput.setBounds(105, 220, 500, 200);
		fastPanel.add(fastRunOutput);
		
		JLabel notice = new JLabel("Running consecutivly will display total stats");
		notice.setBounds(215, 460, 278, 16);
		fastPanel.add(notice);
		
		JLabel fastBetOnLabel = new JLabel("# bet on :");
		fastBetOnLabel.setBounds(265, 135, 100, 30);
		fastPanel.add(fastBetOnLabel);
		fastBetOnLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		fastBetOn = new JTextField();
		fastBetOn.setBorder(new LineBorder(new Color(0, 0, 0)));
		fastBetOn.setBounds(370, 140, 130, 26);
		fastBetOn.setBackground(new Color(240,241,244));
		fastPanel.add(fastBetOn);
		fastBetOn.setColumns(10);
		
		Bases bases_2 = new Bases();
		bases_2.setBackground(back);
		bases_2.setBounds(0, -70, 701, 701);
		fastPanel.add(bases_2);
		bases_2.setLayout(null);
		
		JButton slowButton = new JButton("Play Slow Mode");
		slowButton.setBackground(new Color(84, 118, 68));
		slowButton.setContentAreaFilled(false);
		slowButton.setBounds(280, 230, 150, 40);
		menuPanel.add(slowButton);
		
		JButton fastButton = new JButton("Play Fast Mode");
		fastButton.setBackground(new Color(84, 118, 68));
		fastButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		fastButton.setOpaque(false);
		fastButton.setBounds(280, 280, 150, 40);
		menuPanel.add(fastButton);
		
		JButton rulesButton = new JButton("Rules");
		rulesButton.setBounds(280, 330, 150, 40);
		menuPanel.add(rulesButton);
		
		JLabel Title = new JLabel("Grand Slam");
		Title.setBackground(new Color(84, 118, 68));
		Title.setBounds(105, 120, 500, 72);
		menuPanel.add(Title);
		Title.setFont(new Font("Mukta Mahee", Font.BOLD, 99));
		
		JButton quitButton = new JButton("Exit");
		quitButton.setBounds(280, 380, 150, 40);
		menuPanel.add(quitButton);
		
		Bases bases = new Bases();
		bases.setLocation(0, -70);
		bases.setBackground(back);
		bases.setSize(701, 701);
		getContentPane().add(bases);
		bases.setLayout(null);
		
		
		
		
		//https://www.codejava.net/java-se/swing/jbutton-basic-tutorial-and-examples#AddJButtonEvent
		//The following code controls what each button does
		slowButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				tabbedPane.setVisible(true);
				RunnerCasino.mode = "slow";
			}
		});
		
		fastButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
				tabbedPane.setVisible(true);
				RunnerCasino.mode = "fast";
			}
		});
		
		rulesButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				tabbedPane.setVisible(true);
			}
		});
		
		quitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		runSlow.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				slowRunOutput.setVisible(true);
				int BetLetters = 0;
				for(int i = 0; i < slowBetOn.getText().length(); i++) {
					if(slowBetOn.getText().charAt(i) < 48 || slowBetOn.getText().charAt(i) > 57) {
						BetLetters++;
					}
				}
				for(int i = 0; i < slowAmountBet.getText().length(); i++) {
					if(slowAmountBet.getText().charAt(i) < 48 || slowAmountBet.getText().charAt(i) > 57) {
						BetLetters++;
					}
				}
				if(BetLetters > 0) {
					slowRunOutput.setText("Please enter valid, whole number values in the input fields");
				}
				else{
					if(Integer.parseInt(slowBetOn.getText()) >= 0 && Integer.parseInt(slowBetOn.getText()) <= 10) {
					RunnerCasino.num = Integer.parseInt(slowBetOn.getText());
					RunnerCasino.bet = Integer.parseInt(slowAmountBet.getText());
					run.runCasino();
					switch(slow) {
						case 1:
							slow1.setVisible(true);
							slow1.setText(output);
							break;
						case 2:
							slow2.setVisible(true);
							slow2.setText(output);
							break;
						case 3:
							slow3.setVisible(true);
							slow3.setText(output);
							break;
						case 4:
							slow4.setVisible(true);
							slow4.setText(output);
							break;
						case 5:
							slow5.setVisible(true);
							slow5.setText(output);
							break;
						case 6:
							slow6.setVisible(true);
							slow6.setText(output);
							break;
						case 7:
							slow7.setVisible(true);
							slow7.setText(output);
							break;
						case 8:
							slow8.setVisible(true);
							slow8.setText(output);
							break;
						case 9:
							slow9.setVisible(true);
							slow9.setText(output);
							break;
						case 10:
							slow10.setVisible(true);
							slow10.setText(output);
							runSlow.setVisible(false);
					}
					slowRunOutput.setText("You won a total of " + RunnerCasino.totalwins + " times, for an average of " + df.format(check.getAvgWins()) + 
							" wins per game. You bet a total of $" + RunnerCasino.totalbet + " and won a total of $" + RunnerCasino.totalwon + 
							", for an expected value of " + df.format(check.getExVal()) + ".");
					slow++;
					}
					else {
						slowRunOutput.setText("Please enter a valid number to bet on \nNumber bet on must be 0-10 (inclusive)");
					}
				}
			}
			});
		
		slowBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setVisible(false);
				//resets all statistics
				RunnerCasino.runs = 0; RunnerCasino.wins = 0; RunnerCasino.bet = 0; RunnerCasino.num = 0; RunnerCasino.totalruns = 0;
				RunnerCasino.totalbet = 0; RunnerCasino.totalwon = 0; RunnerCasino.totalwins = 0;
				RunnerCasino.mode = "";
				output = "";
				slow1.setText("");
				slow2.setText("");
				slow3.setText("");
				slow4.setText("");
				slow5.setText("");
				slow6.setText("");
				slow7.setText("");
				slow8.setText("");
				slow9.setText("");
				slow10.setText("");
				slowRunOutput.setText("");
				slow = 1;
			}
		});
		
		rulesBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setVisible(false);
			}
		});
		
		fastBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setVisible(false);
				//resets all statistics
				RunnerCasino.runs = 0; RunnerCasino.wins = 0; RunnerCasino.bet = 0; RunnerCasino.num = 0; RunnerCasino.totalruns = 0;
				RunnerCasino.totalbet = 0; RunnerCasino.totalwon = 0; RunnerCasino.totalwins = 0;
				RunnerCasino.mode = "";
				output = "";
				fastRunOutput.setText("");
			}
		});
		
		runFast.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int BetLettersf = 0;
				for(int i = 0; i < fastBetOn.getText().length(); i++) {
					if(fastBetOn.getText().charAt(i) < 48 || fastBetOn.getText().charAt(i) > 57) {
						BetLettersf++;
					}
				}
				for(int i = 0; i < fastRuns.getText().length(); i++) {
					if(fastRuns.getText().charAt(i) < 48 || fastRuns.getText().charAt(i) > 57) {
						BetLettersf++;
					}
				}
				if(BetLettersf > 0) {
					fastRunOutput.setText("Please enter valid, whole number values in the input fields");
				}
				else{
				if(Integer.parseInt(fastBetOn.getText()) < 0 || Integer.parseInt(fastBetOn.getText()) > 10){
					fastRunOutput.setText("Please enter a valid number to bet on \nNumber bet on must be 0-10 (inclusive)");
				}
				else if(Integer.parseInt(fastRuns.getText()) < 0) {
					fastRunOutput.setText("Please enter a positive number of games");
				}
				else {
				RunnerCasino.num = Integer.parseInt(fastBetOn.getText());
				RunnerCasino.runs = Integer.parseInt(fastRuns.getText());
				run.runCasino();
				fastRunOutput.setText(output);
				}
			}
			}
		});
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void setOutput(String s) {
		output = s;
	}
}


//draws background
class Bases extends JPanel{
	public Bases() {
		setSize(701,701);
		setVisible(true);
		
	}
	
	public void paint(Graphics g) {
		field(g);
	}
	
	public void field(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		//base circles
		g2.setColor(new Color(200,158,130));
		g2.fillOval(291,515,125,125);
		g2.fillOval(122,355,100,100);
		g2.fillOval(488,355,100,100);
		g2.fillOval(306,200,100,100);
		g2.fillOval(331,371,50,50);
		//lines between bases
		g2.setStroke(new BasicStroke(60));
		g2.drawLine(353, 582, 546, 400);
		g2.drawLine(353, 582, 166, 400);
		g2.setStroke(new BasicStroke(45));
		g2.drawLine(156, 400, 356, 230);
		g2.drawLine(556, 400, 356, 230);
		//filler
		g2.drawLine(536, 360, 396, 230);
		g2.drawLine(176, 360, 316, 230);
		//arc
		g2.drawArc(156, 210, 400, 370, 0, 180);
		//bases
		g2.setColor(Color.WHITE);
		g2.fillRect(344, 570, 25, 25);
		g2.fillRect(346, 390, 20, 10);
		g2.rotate(Math.toRadians(45),356,244);
		g2.fillRect(344, 231, 25, 25);
		g2.rotate(Math.toRadians(315),356,244);
		g2.rotate(Math.toRadians(45),172,403);
		g2.fillRect(160, 390, 25, 25);
		g2.rotate(Math.toRadians(315),172,403);
		g2.rotate(Math.toRadians(45),542,403);
		g2.fillRect(530, 390, 25, 25);
		
	}
}