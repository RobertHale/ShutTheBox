import java.util.ArrayList;

public class Player {
	private ArrayList<Integer> numbers;
	private int highestNum;
	
	public Player(){
		highestNum = 12;
		numbers = new ArrayList<Integer>();
		for(int i = 0; i < highestNum; i++){
			numbers.add(i + 1);
		}
	}
	
	public Player(int newHigh){
		highestNum = newHigh;
		for(int i = 0; i < highestNum; i++){
			numbers.add(i + 1);
		}
	}
	
	public boolean check(int num){
		return numbers.contains(num);
	}
	
	public void remove(int num){
		numbers.remove(numbers.indexOf(num));
	}
	
	public void getCurrent(){
		System.out.println(numbers.toString());
	}
	
	public void printBoard(){
		for(int i = 1; i <= highestNum; i++){
			if(numbers.contains(i)){
				System.out.print(numbers.get(numbers.indexOf(i)) + " ");
			}else{
				System.out.print("* ");
			}
		}
		System.out.println();
	}
	
	public int getScore(){
		int score = 0;
		for(int i = 0; i < numbers.size(); i++){
			score += numbers.get(i);
		}
		return score;
	}
	
	public void getStats(Player[] players){
		System.out.println("\tNumber of boxes shut: " + (highestNum - numbers.size()));
		System.out.println("\tNumber of boxes open: " + numbers.size());
		System.out.println("\tHighest number left open: " + numbers.get(numbers.size() - 1));
		System.out.println("\tLowest number left open: " + numbers.get(0));
		int numPlayers = players.length;
		int score = getScore();
		int place = 1;
		for(int i = 0; i < numPlayers; i++){
			if(players[i].getScore() < score){
				place++;
			}
		}
		String placeName;
		if(place == 1){
			placeName = "1st";
		}else if(place == 2){
			placeName = "2nd";
		}else if(place == 3){
			placeName = "3rd";
		}else{
			placeName = place + "th";
		}
		System.out.println("\tFinal placing: " + placeName);
		System.out.println("\tTotal score: " + score);
	}
}
