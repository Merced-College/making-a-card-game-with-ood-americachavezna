//America Chavez, Samantha Castillo
//9-23-2025
//Arraylist card game with OOP

//package cardGame;

//importing libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
//added code
import javax.swing.JOptionPane;
//added code ^

//create public class
public class CardGame {

	//create variables
	private static ArrayList<Card> deckOfCards = new ArrayList<Card>();
	private static ArrayList<Card> playerCards = new ArrayList<Card>();

	//main class
	public static void main(String[] args) {

	boolean playAgain = true; //added code
	
	while (playAgain)  { //added code

		//uses scanner to read the information from cards.txt and add them to a new variable called 'input'
		Scanner input = null;
		try {
			input = new Scanner(new File("cards.txt"));
		
		//meant to catch any errors from the get-go
		} catch (FileNotFoundException e) {
			// error
			System.out.println("error");
			e.printStackTrace();
		}

		//while loop splits the input into the proper variables
		while(input.hasNext()) {
			String[] fields  = input.nextLine().split(",");
			//	public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
			Card newCard = new Card(fields[0], fields[1].trim(),
					Integer.parseInt(fields[2].trim()), fields[3]);
			deckOfCards.add(newCard);	
		}

		//randomizes the cards by calling back on shuffle module(?)
		shuffle();

		//for(Card c: deckOfCards)
			//System.out.println(c);

		//deal the player 5 cards
		for(int i = 0; i < 4; i++) {
			playerCards.add(deckOfCards.remove(i));
		}
		
		//prints out the player cards and includes pairs
		System.out.println("players cards");
		for(Card c: playerCards)
			System.out.println(c);

		System.out.println("pairs is " + checkFor2Kind());


		//added code 
		StringBuilder message = new StringBuilder("Player's cards: \n");

		for (Card c: playerCards) {
			message.append(c.toString()).append("\n");
		}

		message.append("\n Has a pair: ").append(checkFor2Kind());

		//yesJOptionPane.showMessageDialog(null, message.toString(), "Card Game Result", JOptionPane.INFORMATION_MESSAGE);
		//added code ^

		// added boolean code
		Scanner scanner = new Scanner (System.in);
		System.out.println("Want to play again?");
		String play = scanner.nextLine().toLowerCase();
		
		if (play.equals("yes")) { //boolean added code
			playAgain = true;
		}

		else if (play.equals("no")) {
			System.out.println ("Thanks for playing.");
			playAgain = false;
			break;
		}

		else {
			System.out.println ("Not an option. Thanks for playing.");
			playAgain = false;
			break;
		}
	} //playagin boolean end

} ////end main	 

	//shuffle module(?)
	public static void shuffle() {

		//shuffling the cards by deleting and reinserting
		for (int i = 0; i < deckOfCards.size(); i++) {
			int index = (int) (Math.random()*deckOfCards.size());
			Card c = deckOfCards.remove(index);
			//System.out.println("c is " + c + ", index is " + index);
			deckOfCards.add(c);
		}
	}

	//check for 2 of a kind in the players hand
	public static boolean checkFor2Kind() {

		//initializes variable count to 0 in order to check pairs
		int count = 0;
		for(int i = 0; i < playerCards.size() - 1; i++) {
			Card current = playerCards.get(i);
			Card next = playerCards.get(i+1);
			
			for(int j = i+1; j < playerCards.size(); j++) {
				next = playerCards.get(j);
				//System.out.println(" comparing " + current);
				//System.out.println(" to " + next);
				if(current.equals(next))
					count++;
			}//end of inner for
			if(count == 1)
				return true;

		}//end outer for
		return false;
	}

}//end class