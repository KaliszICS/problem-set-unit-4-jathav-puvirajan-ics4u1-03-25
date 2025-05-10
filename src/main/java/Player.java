import java.util.*; 

/**
* Represents a player in the card game.
* @author Jathav Puvirajan
*/

public class Player{
    private String name;
    private int age;
    private List<Card> hand;

    /**
    * Constructs a player with a name, age, and initial hand.
    *
    * @param name        the player's name
    * @param age         the player's age
    * @param initialHand an array of cards for the player to start with
    */
    public Player(String name, int age, Card[] initialHand) {
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<>(Arrays.asList(initialHand));
    }

    /**
    * Constructs a player with an empty initial hand.
    *
    * @param name the player's name
    * @param age  the player's age
    */
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<>();
    }

    /**
    * Returns the player's name.
    *
    * @return the name
    */
    public String getName() {
        return name;
    }

    /**
    * Returns the player's age.
    *
    * @return the age
    */
    public int getAge() {
        return age;
    }

    /**
    * Returns the cards currently in the player's hand.
    *
    * @return an array of cards in hand
    */
    public Card[] getHand() {
        return hand.toArray(new Card[0]);
    }

    /**
    * Returns the number of cards in the player's hand.
    *
    * @return the hand size
    */
    public int size(){
        return hand.size();
    }

    /**
    * Draws a card from the deck and adds it to the hand.
    *
    * @param deck the deck to draw from
    */
    public void draw(Deck deck){
        if(deck == null) return;
        Card card = deck.draw();
        if(card != null){
            hand.add(card);
        }
    }

    /**
    * Discards a card from the hand to the discard pile.
    *
    * @param card        the card to discard
    * @param discardPile the discard pile
    * @return true if the card was discarded, false if the caard is not in the hand, or if either the card or deck is null.
    */
    public boolean discardCard(Card card, DiscardPile discardPile){
        if(card == null || discardPile == null) return false;
        if(!hand.contains(card)) return false;
        hand.remove(card);
        discardPile.addCard(card);
        return true;
    }

    /**
    * Returns a card from the hand to the deck.
    *
    * @param card the card to return
    * @param deck the deck
    * @return true if the card is in the deck and was returned, false if the card is not in the hand, or if either the deck or card is null.
    */
    public boolean returnCard(Card card, Deck deck){
        if(card == null || deck == null) return false;
        if(!hand.contains(card)) return false;
        hand.remove(card);
        deck.addCard(card);
        return true;
    }

    /**
    * Returns a string representation of the player and their hand.
    *
    * @return a string describing the player in the format of "Mr. Kalisz, 99, Ace of hearts, King of Hearts, Queen of Hearts, Jack of Hearts, 9 of Spades."
    */
    @Override
    public String toString(){
        String r = name + ", " + age + ", ";
        for(int i = 0; i < hand.size(); i++) {
            String c = hand.get(i).toString();
            r = r + c;
            if(i != hand.size() - 1){
                r = r + ", ";
            }else{
                r = r + ".";
            }
        }
        return r;
    }
}

