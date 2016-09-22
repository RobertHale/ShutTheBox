import java.util.Random;
import java.util.Scanner;

public class ShutTheDoor {
	
	public static int die1;
	public static int die2;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of players:");
		int numPlayers = sc.nextInt();
		sc.nextLine();
		System.out.println();
		Player[] players = new Player[numPlayers];
		for(int i = 0; i < players.length; i++){
			players[i] = new Player();
			letsPlay(players[i], i, sc);
			System.out.println("*****Player #" + (i + 1) + " has finished*****\n");
		}
		int winner = getWinner(players);
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("*****Player #" + winner + " is the WINNER*****");
		for(int i = 0; i < players.length; i++){
			System.out.println("Stats for player #" + (i+1) + ":");
			players[i].getStats(players);
		}
		System.out.println("*****Player #" + winner + " is the WINNER*****");
	}
	
	public static void letsPlay(Player player, int num, Scanner sc){
		boolean keepGoing = true;
		System.out.println("player #" + (num + 1) + " you are up!");
		while(keepGoing){
			System.out.println("You're current board is:");
			player.printBoard();
			rollDice();
			System.out.println("\nyou rolled:" + die1 + " " + die2 + "\n");
			keepGoing = finishTurn(sc, player);
		}
	}
	
	public static void rollDice(){
		Random r = new Random();
		die1 = r.nextInt(6) + 1;
		die2 = r.nextInt(6) + 1;
	}
	
	public static boolean finishTurn(Scanner sc, Player player){
		int total = die1 + die2;
		while(total > 0){
			System.out.println("your current total is " + total);
			System.out.print("Enter your number to close or -1 if out of luck:");
			int input = getInput(sc, total, player);
			System.out.println();
			if(input != -1){
				total -= input;
				player.remove(input);
			}else{
				return false;
			}	
		}
		return true;
	}
	
	public static int getInput(Scanner sc, int total, Player player){
		int input = sc.nextInt();
		if(input == -1){
			return input;
		}else if(!player.check(input) || !(input <= total)){
			System.out.println("Number invalid, please enter new number:");
			input = getInput(sc, total, player);
		}
		return input;
	}
	
	public static int getWinner(Player[] players){
		int winner = 0;
		int winTotal = players[0].getScore();
		for(int i = 1; i < players.length; i++){
			if(players[i].getScore() < winTotal){
				winner = i;
				winTotal = players[i].getScore();
			}
		}
		return winner + 1;
	}
}
