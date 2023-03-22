import java.util.*;
import java.lang.Math;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();

    public static final String[] NAMES = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
    public static final String[] SUITS = {"clubs", "spades", "hearts", "diamonds"};
    public static final int[] RANKS = {2,3,4,5,6,7,8,9,10,11,12,13,14};

    public Deck () {
        initializeDeck();
    }

    public void setDeck (ArrayList<Card> newDeck) {
        deck.clear();
        deck.addAll(newDeck);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void initializeDeck() {
        deck.clear();
        for(String suit : SUITS){
            for(int rank : RANKS) {
                deck.add(new Card(NAMES[rank-2], suit, rank));
            }
        }
    }

    public Card getCard(int index) {
        return deck.get(index);
    }

    public Card dealTopCard() {
        return deck.remove(0);
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }
    
    public void shuffle2() {
        int max = 10;
        int min = 2;
        int range = max - min + 1;
        int numCardToShuffle = (int)(Math.random() * range) + min;
        ArrayList<Card> listToShuffle = new ArrayList<Card>();
        for(int i = 0; i<numCardToShuffle; i++) {
            listToShuffle.add(deck.remove(0));
        }

        max = deck.size();
        min = 1;
        range = max - min + 1;
        deck.addAll((int)(Math.random() * range) + min, listToShuffle);
    }

    public String toString() {
        if(deck.size() == 0) {
            return "No cards in the deck!";
        }
        String toReturn = "";
        for(int i = 0; i<deck.size(); i++) {
            toReturn = toReturn.concat(deck.get(i).toString());
        }
        return toReturn;
    }
    // what's cooki good looki :D
}