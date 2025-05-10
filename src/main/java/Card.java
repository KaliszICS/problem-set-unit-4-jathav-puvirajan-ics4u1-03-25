/**
* Represents a playing card with a name, suit, and value.
* @author Jathav Puvirajan
*/

public class Card{
    private String name;
    private String suit;
    private int value;

    /**
    * Constructs a new Card with the specified name, suit, and value.
    *
    * @param name  the name or rank of the card (e.g., "Ace", "2", ..., "King")
    * @param suit  the suit of the card (e.g., "Hearts", "Clubs", "Spades", "Diamonds")
    * @param value the integer value of the card (typically 1 to 13)
    */

    public Card(String name, String suit, int value){
        this.name = name;
        this.suit = suit;
        this.value = value;
    }
    
    /**
    * Returns the name or rank of the card.
    * 
    * @return the name of the card
    */
    public String getName(){
        return this.name;
    }
    
    /**
    * Returns the suit of the card.
    *
    * @return the suit of the card
    */
    public String getSuit(){
        return this.suit;
    }

    /**
    * Returns the numeric value of the card.
    *
    * @return the value of the card
    */
    public int getValue(){
        return this.value;
    }

    /**
    * Returns a string representation of the card.
    *
    * @return a string describing the card in the format "Ace of Spades".
    */
    @Override
    public String toString(){
        return this.name + " of " + this.suit;
    }

    /**
    * Compares this card to another card for and checks if they are equal. 
    * Two cards are equal if they have the same name, suit, and value.
    *
    * @param obj the object to compare with
    * @return true if the cards are equal, false if the cards are not equal.
    */
    @Override
    public boolean equals(Object obj){
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Card card = (Card)obj;
        return this.name.equals(card.name) && this.suit.equals(card.suit) && this.value == card.value;
    }

}