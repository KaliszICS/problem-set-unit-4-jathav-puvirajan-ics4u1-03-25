import java.util.*;

/**
* Represents a deck of playing cards.
* @author Jathav Puvirajan
*/

public class Deck{

    public static final String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
    public static final String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    private List<Card> cards;

    /**
    * Constructs a deck from an existing array of cards.
    *
    * @param cardsArray the initial cards in the deck
    */
    public Deck(Card[] cardsArray) {
        this.cards = new ArrayList<>(Arrays.asList(cardsArray));
    }

    /**
    * Constructs a standard 52-card deck.
    */
    public Deck() {
        this.cards = new ArrayList<>();
        for (String suit : suits) {
            for (int i = 0; i < names.length; i++) {
                cards.add(new Card(names[i], suit, i + 1));
            }
        }
    }

    /**
    * Returns the number of cards in the deck.
    *
    * @return the size of the deck
    */
    public int size(){
        return cards.size();
    }

    /**
    * Draws and removes the top card from the deck.
    *
    * @return the drawn card, or null if the deck is empty
    */
    public Card draw(){
        if(cards.isEmpty()) return null;
    
        return cards.remove(0);
    }

    /**
    * Shuffles the deck randomly.
    */
    public void shuffle(){
        if(cards.isEmpty()) return;
        Random r = new Random();
        for(int i = cards.size() - 1; i > 0; i--){
            Collections.swap(cards, i, r.nextInt(i+1));
        }
    }

    /**
    * Adds a card to the deck.
    *
    * @param card the card to add
    */
    public void addCard(Card card){
        if(card == null) return;
        cards.add(card);
    }


    /**
    * Adds a set of cards to the deck and shuffles.
    *
    * @param cardsArray the array of cards to add
    */
    public void reshuffle(Card[] cardsArray){
        for(int i = 0; i < cardsArray.length; i++){
            Card card = cardsArray[i];
            if(card != null) cards.add(cardsArray[i]);
        }
        shuffle();
    }

}