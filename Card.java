//America Chavez, Samantha Castillo
//9-23-2025
//Arraylist card game with OOP

public class Card {

     //data variables, they describe our Card objects in the computer
    public String cardSuit;
    public String cardName;
    public int cardValue; 
    public String cardPicture;

    //constructor 
    public Card () {
        this.cardSuit = "cardSuit";
        this.cardName = "card name";
        this.cardValue = 10;
        this.cardPicture = "picture";
    }

    //nondefault constructor
    public Card (String cardSuit, String cardName, int cardValue, String cardPicture) {
        this.cardSuit = cardSuit;
        this.cardName = cardName;
        this.cardValue = cardValue;
        this.cardPicture = cardPicture;
    }

    //setters - accessors
    public void setCardSuit (String cardSuit) {
        this.cardSuit = cardSuit;
    }

    public void setCardName (String cardName) {
        this.cardName = cardName;
    }

    public void setCardValue (int cardValue) {
        this.cardValue = cardValue;
    }
    
    public void setCardPicture (String cardPicture) {
        this.cardPicture = cardPicture;
    }

    //getters - mutators
    public String getCardSuit() {
        return cardSuit;
    }

    public String getCardName() {
        return cardName;
    }

    public int getCardValue() {
        return cardValue;
    }

    public String getCardPicture() {
        return cardPicture;
    }

    @Override 
    public String toString() {
        return cardSuit + ", " + cardName + ", " + cardValue + " " + cardPicture;
    }

} //end Card class
