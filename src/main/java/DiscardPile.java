import java.util.*;

/**
* Represents a pile of discarded cards.
* @author Jathav Puvirajan
*/

public class DiscardPile {

    private List<Card> pile; 

    /**
    * Constructs a discard pile from an existing array.
    *
    * @param cardsArray the initial cards
    */
    public DiscardPile(Card[] cardsArray) {
        this.pile = new ArrayList<>(Arrays.asList(cardsArray));
    }

    /**
    * Constructs an empty discard pile.
    */
    public DiscardPile() {
        this.pile = new ArrayList<>();
    }

    /**
    * Returns all cards in the discard pile as an array.
    *
    * @return an array that consists of the discard pile
    */
    public Card[] getDiscardPile(){
        return pile.toArray(new Card[0]);
    }

    /**
    * Returns the number of cards in the pile.
    *
    * @return the size of the discard pile
    */
    public int size(){
        return pile.size();
    }

    /**
    * Adds a card to the pile.
    *
    * @param card the card to add
    */
    public void addCard(Card card){
        if(card == null) return;
        pile.add(card);
    }

    /**
    * Removes a specific card from the pile.
    *
    * @param card the card to remove
    * @return the removed card, or null if not found
    */
    public Card removeCard(Card card) {
        if (pile.remove(card)) {
            return card;
        }
        return null;
    }

    /**
    * Removes and returns all cards from the pile.
    *
    * @return an array of all cards that were in the pile
    */
    public Card[] removeAll() {
        if(pile.isEmpty()) return new Card[0];
        Card[] cards = pile.toArray(new Card[0]);
        pile.removeAll(pile);
        return cards;
    }

    /**
    * Returns a string representation of the discard pile.
    *
    * @return a list of cards in the format "Ace of hearts, King of Hearts, Queen of Hearts, Jack of Hearts, 9 of Spades."
    */
    @Override
    public String toString(){
        String r = "";
        for(int i = 0; i < pile.size(); i++) {
            String c = pile.get(i).toString();
            r = r + c;
            if(i != pile.size() - 1){
                r = r + ", ";
            }else{
                r = r + ".";
            }
        }
        return r;

    }
}